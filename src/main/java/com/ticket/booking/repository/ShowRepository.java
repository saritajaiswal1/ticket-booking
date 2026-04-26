package com.ticket.booking.repository;

import com.ticket.booking.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {
    List<Show> findByMovieId(String movieId);

    Optional<Show> findById(String id);

    @Query("SELECT s FROM Show s WHERE s.city = :city AND s.movieId = :movieId AND s.startTime BETWEEN :start AND :end")
    List<Show> findShows(String city, String movieId,
                         LocalDateTime start,
                         LocalDateTime end);
}