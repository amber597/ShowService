package com.showservice.ShowService.exception;

import java.util.List;

public class SeatsUnavailableException extends RuntimeException {
    public SeatsUnavailableException(List<Long> seatIds) {
        super("These seatIds are unavailable: " + seatIds);
    }
}
