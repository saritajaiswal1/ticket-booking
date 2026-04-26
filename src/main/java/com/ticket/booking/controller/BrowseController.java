package com.ticket.booking.controller;

import com.ticket.booking.model.Show;
import com.ticket.booking.service.BrowseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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