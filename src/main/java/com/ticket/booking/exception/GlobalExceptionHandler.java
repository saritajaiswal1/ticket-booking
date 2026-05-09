package com.ticket.booking.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handle(RuntimeException ex) {
        return ResponseEntity.badRequest().body(
                Map.of("error", ex.getMessage())
        );
    }

    @ExceptionHandler(SeatUnavailableException.class)
    public ResponseEntity<?> handle(SeatUnavailableException ex) {
        return ResponseEntity.badRequest().body(
                Map.of("message ", ex.getMessage())
        );
    }

    @ExceptionHandler(SeatBookedException.class)
    public ResponseEntity<?> handle(SeatBookedException ex){
        return ResponseEntity.badRequest().body(Map.of("message ",ex.getMessage()));
    }
}
