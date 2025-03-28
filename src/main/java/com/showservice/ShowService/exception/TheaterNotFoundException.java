package com.showservice.ShowService.exception;

public class TheaterNotFoundException extends RuntimeException {
    public TheaterNotFoundException(Long theaterId) {
        super("There is no theater with id: " + theaterId);
    }
}
