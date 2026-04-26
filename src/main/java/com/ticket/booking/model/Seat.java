package com.ticket.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    private String id;

    private String showId;
    private int price;
    private boolean booked;

    @Version
    private int version; // optimistic locking
}
