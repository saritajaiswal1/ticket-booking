package com.ticket.booking.controller;

import com.ticket.booking.model.Show;
import com.ticket.booking.service.BrowseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class BrowseController {

    private final BrowseService service;

    @GetMapping
    public List<Show> browse(@RequestParam String movieId) {
        return service.browse(movieId);
    }
}