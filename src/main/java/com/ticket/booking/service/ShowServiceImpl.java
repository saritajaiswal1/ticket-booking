package com.ticket.booking.service;

import com.ticket.booking.model.Show;
import com.ticket.booking.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService{
   private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public List<Show> searchShows(String city, String movieId, LocalDateTime date) {
       // return showRepository.findByMovieId(movieId);
            LocalDateTime startDateTime;
            LocalDateTime endDateTime;

            if (date != null && !date.isEqual(date.now())) {
                LocalDate localDate = LocalDate.parse(date.toLocalTime().toString()); // format: yyyy-MM-dd
                startDateTime = localDate.atStartOfDay();
                endDateTime = localDate.plusDays(1).atStartOfDay();
            } else {
                // current → future
                startDateTime = LocalDateTime.now();
                endDateTime = LocalDateTime.now().plusYears(1);
            }

            return showRepository.findShows(city, movieId, startDateTime, endDateTime);
        }

    @Override
    public String createShow(Show show) {
        if (showRepository.findById(show.getId()).isPresent()) {
            return "Show already exists";
        }

        showRepository.save(show);
        return "Show created";
    }
}
