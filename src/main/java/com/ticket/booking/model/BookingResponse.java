package com.ticket.booking.model;

import java.util.List;

public record BookingResponse(
        String bookingId,
        double totalAmount,
        List<String> seats
) {}
