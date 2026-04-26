package com.ticket.booking.model;

import java.util.List;

public record BookingRequest(
        String showId,
        List<String> seatIds,
        String offerType
) {}
