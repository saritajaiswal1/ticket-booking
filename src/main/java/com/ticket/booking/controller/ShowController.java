package com.ticket.booking.controller;

import com.ticket.booking.model.Show;
import com.ticket.booking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/search")
    public List<Show> searchShows(
            @RequestParam(defaultValue = "Bangalore") String city,
            @RequestParam String movieId,
            @RequestParam(required = false) String date) {

        // If date is not provided, use current date/time
        LocalDateTime searchDateTime;

        if (date == null || date.isBlank()) {
            searchDateTime = LocalDateTime.now();
        } else {
            try {
                if (date.contains("T")) {
                    // Full datetime input
                    searchDateTime = LocalDateTime.parse(date);
                } else {
                    // Only date input
                    searchDateTime = LocalDate.parse(date).atStartOfDay();
                }
            } catch (Exception e) {
                throw new RuntimeException("Invalid date format. Use yyyy-MM-dd or yyyy-MM-ddTHH:mm:ss");
            }
        }

        return showService.searchShows(city, movieId, searchDateTime);
    }
    @PostMapping("/createShow")
    public String createShow(
            @RequestBody Show show
            ) {

        return showService.createShow(show);
    }
}
