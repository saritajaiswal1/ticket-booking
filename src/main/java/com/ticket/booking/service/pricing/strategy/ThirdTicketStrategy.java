package com.ticket.booking.service.pricing.strategy;

import com.ticket.booking.model.Seat;
import com.ticket.booking.model.Show;
import com.ticket.booking.service.pricing.PricingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("THIRD_TICKET")
public class ThirdTicketStrategy implements PricingStrategy {

    @Override
    public double apply(List<Seat> seats, Show show) {
        var total = seats.stream().mapToDouble(Seat::getPrice).sum();

        return seats.size() >= 3
                ? total - seats.get(2).getPrice() * 0.5
                : total;
}
}
