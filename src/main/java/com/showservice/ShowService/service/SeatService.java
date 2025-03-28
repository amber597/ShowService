package com.showservice.ShowService.service;

import com.showservice.ShowService.model.Seat;

import java.util.List;

public interface SeatService {
    public boolean confirmBooking(Long userId, List<Long> seatIds);

    public boolean bookSeats(Long userId, List<Long> seatIds);
}
