package com.ticket.booking.service.pricing;

import com.ticket.booking.model.Seat;
import com.ticket.booking.model.Show;

import java.util.List;

public interface PricingStrategy {
    double apply(List<Seat> seats, Show show);
}
