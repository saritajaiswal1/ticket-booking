package com.ticket.booking.service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ticket.booking.exception.SeatBookedException;
import com.ticket.booking.exception.SeatUnavailableException;
import com.ticket.booking.model.*;
import com.ticket.booking.repository.BookingRepository;
import com.ticket.booking.repository.SeatRepository;
import com.ticket.booking.repository.ShowRepository;
import com.ticket.booking.service.pricing.PricingStrategy;
import com.ticket.booking.service.pricing.factory.PricingStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**public class BookingService {

    private final ShowRepository showRepo;

    public BookingService(ShowRepository showRepo) {
        this.showRepo = showRepo;
    }

    public Booking bookTickets(String showId, List<String> seatIds, String offerType) {

        Show show = showRepo.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        List<Seat> selectedSeats = show.seats().stream()
                .filter(s -> seatIds.contains(s.seatId()) && !s.isBooked())
                .toList();

        if (selectedSeats.size() != seatIds.size()) {
            throw new RuntimeException("Some seats already booked");
        }

        PricingStrategy strategy =
                PricingStrategyFactory.getStrategy(offerType, show.startTime());

        double price = strategy.apply(selectedSeats);

        // Mark seats booked (simulate)
        selectedSeats.forEach(s -> new Seat(s.seatId(), s.price(), true));

        return new Booking(
                UUID.randomUUID().toString(),
                showId,
                selectedSeats,
                price
        );
    }
}**/

@Service
@RequiredArgsConstructor
//@NoArgsConstructor(force = true)
public class BookingService {

    private final SeatRepository seatRepo;
    private final ShowRepository showRepo;
    private final BookingRepository bookingRepo;
    private final PricingStrategyFactory factory;

    @Transactional
    public BookingResponse book(BookingRequest request) {

       /* var show = showRepo.findById(request.showId())
                .orElseThrow(() -> new RuntimeException("Show not found"));*/
        Show show;

        if (showRepo == null) {
            // You cannot save without repo, so just create an object (not persisted)
            show = new Show();
            show.setId(request.showId());
            // set other fields if needed
        } else {
            show = showRepo.findById(request.showId())
                    .orElseThrow(() -> new RuntimeException("Show not found"));
        }



       // var seats = seatRepo.findAllById(request.seatIds());
        List<Seat> seats;

        if (seatRepo == null) {
            // Create seats in memory (NOT saved to DB)
            seats = request.seatIds().stream()
                    .map(id -> {
                        Seat seat = new Seat();
                        seat.setId(id);
                        seat.setPrice(40);
                        seat.setBooked(false);
                        return seat;
                    })
                    .toList();
        } else {
            seats = seatRepo.findAllById(request.seatIds());
        }

        // Validate seats
        if (seats.size() != request.seatIds().size()) {
            throw new RuntimeException("Invalid seat selection");
        }

        if (seats.stream().anyMatch(Seat::isBooked)) {
            throw new RuntimeException("Some seats already booked");
        }

      //  PricingStrategy strategy = factory.get(request.offerType());

     /**   if (strategy == null) {
            // fallback strategy creation based on offerType
            strategy.apply(seats,show);
           // strategy = createDefaultStrategy(request.offerType());
        }**/

        PricingStrategy strategy = factory.get("DEFAULT");

        // Pricing
        strategy = factory.get(request.offerType());

        var total = strategy.apply(seats, show);

        // Lock seats
        seats.forEach(seat -> seat.setBooked(true));
        seatRepo.saveAll(seats);

        // Save booking
        var booking = new Booking();
        booking.setId(UUID.randomUUID().toString());
        booking.setShowId(show.getId());
        booking.setTotalAmount(total);

        bookingRepo.save(booking);

        return new BookingResponse(
                booking.getId(),
                total,
                seats.stream().map(Seat::getId).toList()
        );
    }

    public BookingResponse bookTickets(String id, int seat) {

           //threads-> try to acquire locks->t1->payment gateway
           //lock the seats->pay->transaction successful->allocate the seat to t1
           //t2->t1, t2->n-s1 seats

        Booking booking=bookingRepo.findById(id)
                .orElseThrow(()->new SeatUnavailableException("Seat with requested id is unavailable for booking : "+id));

        try{
            //Book seat
            booking.setSeatNumber(seat);

            Booking savedBooking = bookingRepo.save(booking);

            //Thread pool for async tasks if needed
            ExecutorService executor=Executors.newFixedThreadPool(3);

            //Example async task
            executor.submit(()->{System.out.println("Processing payment for seat : "+seat);});

            executor.shutdown();

            return new BookingResponse(savedBooking.getId(),savedBooking.getTotalAmount(),List.of("Seat - "+seat));
        } catch (SeatBookedException e) {
            throw new SeatBookedException("Seat already booked : "+seat);
        }
    }
}
