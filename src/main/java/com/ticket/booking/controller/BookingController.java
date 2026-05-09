package com.ticket.booking.controller;

import com.ticket.booking.model.BookingRequest;
import com.ticket.booking.model.BookingResponse;
import com.ticket.booking.model.BookingSummaryResponse;
import com.ticket.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @PostMapping
    public BookingResponse book(@RequestBody @Valid BookingRequest request) {
        return service.book(request);
    }

    @PostMapping("/{id}")
    public BookingSummaryResponse bookTickets(@PathVariable String id,@RequestParam int seat){
           BookingResponse response=service.bookTickets(id,seat);

           return new BookingSummaryResponse(response.bookingId(), response.seats());
    }
}