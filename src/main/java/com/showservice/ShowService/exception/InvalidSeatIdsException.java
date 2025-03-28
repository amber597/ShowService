package com.showservice.ShowService.exception;

import java.util.List;

public class InvalidSeatIdsException extends RuntimeException {
    public InvalidSeatIdsException(List<Long> invalidIds) {
        super("Invalid seatIds " + invalidIds);
    }
}
