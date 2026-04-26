package com.ticket.booking.service;

import com.ticket.booking.model.Show;

import java.time.LocalDateTime;
import java.util.List;


public interface ShowService {
    List<Show> searchShows(String city, String movieId, LocalDateTime date);

    String createShow(Show show);
}
