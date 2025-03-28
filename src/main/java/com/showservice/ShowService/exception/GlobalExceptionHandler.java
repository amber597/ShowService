package com.showservice.ShowService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidSeatIdsException.class)
    public ResponseEntity<String> handleInvalidSeatIds(InvalidSeatIdsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(SeatsUnavailableException.class)
    public ResponseEntity<String> handleUnavailableSeats(SeatsUnavailableException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGerneralException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    public ResponseEntity<String> handleTheateNotFoundException(TheaterNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
