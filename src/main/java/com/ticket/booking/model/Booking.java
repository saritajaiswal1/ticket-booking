package com.ticket.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    private String id;

    private String showId;

    private double totalAmount;

    public void setSeatNumber(int seat) {
    }
}
