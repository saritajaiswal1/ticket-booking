package com.ticket.booking.service.pricing.factory;

import com.ticket.booking.service.pricing.PricingStrategy;

import java.util.Map;

import com.ticket.booking.model.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PricingStrategyFactory {

        private final Map<String, PricingStrategy> strategies;

    public PricingStrategy get(String type) {
        return strategies.getOrDefault(type,
                (seats, show) -> seats.stream().mapToDouble(Seat::getPrice).sum()
        );
    }

        private PricingStrategy defaultStrategy() {
            return (seats, show) ->
                    seats.stream().mapToDouble(Seat::getPrice).sum();
        }
    }
