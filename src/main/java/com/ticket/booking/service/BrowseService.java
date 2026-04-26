package com.ticket.booking.service;

import com.ticket.booking.model.Show;
import com.ticket.booking.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrowseService {

    private final ShowRepository repo;

    public List<Show> browse(String movieId) {
        return repo.findByMovieId(movieId);
    }
}