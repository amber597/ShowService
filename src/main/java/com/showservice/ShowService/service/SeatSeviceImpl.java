package com.showservice.ShowService.service;

import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatSeviceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatSeviceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public boolean seatAvailable(Long seatId) {
        Optional<Seat> seat =  this.seatRepository.findById(seatId);
        if (seat.isPresent()) {
            return !seat.get().isBooked();
        } else {
            return false;
        }
    }

    @Override
    public boolean bookSeats(Long userId, List<Long> seatIds) {

        try {
            for (Long seatId : seatIds) {
                Seat seat = this.seatRepository.findById(seatId).get();
                seat.setBooked(true);
                seat.setUserId(userId);
                this.seatRepository.save(seat);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
