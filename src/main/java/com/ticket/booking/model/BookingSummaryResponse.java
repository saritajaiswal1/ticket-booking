package com.ticket.booking.model;

import java.util.List;

public record BookingSummaryResponse(
        String bookingId,
        List<String> seats
) {
}
