package com.showservice.ShowService.service;

import java.util.List;

public interface SeatService {
    public boolean seatAvailable(Long seatId);
    public boolean bookSeats(Long userId, List<Long> seatIds);
}
