package com.ticket.booking.service.pricing.strategy;

import com.ticket.booking.model.Seat;
import com.ticket.booking.model.Show;
import com.ticket.booking.service.pricing.PricingStrategy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component("AFTERNOON")
public class AfternoonStrategy implements PricingStrategy {

    @Override
    public double apply(List<Seat> seats, Show show) {
        var total = seats.stream().mapToDouble(Seat::getPrice).sum();

        return show.getStartTime().toLocalTime().isBefore(LocalTime.of(16, 0))
                ? total * 0.8
                : total;
    }
}