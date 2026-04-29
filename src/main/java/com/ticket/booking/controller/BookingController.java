package com.ticket.booking.controller;

import com.ticket.booking.model.BookingRequest;
import com.ticket.booking.model.BookingResponse;
import com.ticket.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}