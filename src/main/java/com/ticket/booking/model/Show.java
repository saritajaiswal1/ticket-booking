package com.ticket.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Show {
    @Id
    private String id;

    private String movieId;
    private String theatreId;

    private LocalDateTime startTime;

    private String city;
}