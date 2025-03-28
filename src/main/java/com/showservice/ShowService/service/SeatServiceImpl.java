package com.showservice.ShowService.service;

import com.showservice.ShowService.enums.BookingType;
import com.showservice.ShowService.exception.InvalidSeatIdsException;
import com.showservice.ShowService.exception.SeatsUnavailableException;
import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public  SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    private void checkInvalidIds(List<Long> seatIds) throws InvalidSeatIdsException {
        List<Long> validIds  = seatRepository.findAllByIdIn(seatIds).stream().map(Seat::getId).toList();
        List<Long> invalidIds = seatIds.stream().filter(id -> !validIds.contains(id)).toList();
        if (!invalidIds.isEmpty()) {
            throw new InvalidSeatIdsException(invalidIds);
        }
    }

    private void checkUnavailableSeats(List<Long> unavailableSeatIds) throws SeatsUnavailableException {
        if (!unavailableSeatIds.isEmpty()) {
            throw new SeatsUnavailableException(unavailableSeatIds);
        }
    }

    private void checkUpdatedRows(Integer updatedRows, List<Long> seatIds) throws RuntimeException {
        if(updatedRows != seatIds.size()) {
            throw new RuntimeException("Could not update seatIds: " + seatIds);
        }
    }


    @Override
    @Transactional
    public boolean confirmBooking(Long userId, List<Long> seatIds) {

        this.checkInvalidIds(seatIds);

        List<Long> unavailableSeatIds = seatRepository.findByIdInAndBookingTypeNot(seatIds, BookingType.AVAILABLE)
                                        .stream().map(Seat :: getId).collect(Collectors.toList());

        this.checkUnavailableSeats(unavailableSeatIds);

        Integer updatedRows = seatRepository.updateBookingByIdIn(seatIds, userId, BookingType.TRANSACTION);

        this.checkUpdatedRows(updatedRows, seatIds);

        return true;
    }

    @Override
    @Transactional
    public boolean bookSeats(Long userId, List<Long> seatIds) {
        this.checkInvalidIds(seatIds);

        List<Long> availableSeats = seatRepository.findByIdInAndUserIdAndBookingType(seatIds, userId, BookingType.TRANSACTION)
                .stream().map(Seat :: getId).collect(Collectors.toList());

        List<Long> unavailableSeatIds = seatIds.stream().filter(seatId -> !availableSeats.contains(seatId)).toList();

        this.checkUnavailableSeats(unavailableSeatIds);

        Integer updatedRows = seatRepository.updateBookingByIdIn(seatIds, userId, BookingType.BOOKED);

        this.checkUpdatedRows(updatedRows, seatIds);

        return true;
    }
}
