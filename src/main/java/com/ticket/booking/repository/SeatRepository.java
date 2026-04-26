package com.ticket.booking.repository;

import com.ticket.booking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    List<Seat> findByShowIdAndBookedFalse(String showId);
}
