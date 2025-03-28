package com.showservice.ShowService.repository;

import com.showservice.ShowService.enums.BookingType;
import com.showservice.ShowService.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByShowId(Long showId);

    List<Seat> findAllByTheaterIdAndShowIdIsNull(Long theaterId);

    List<Seat> findByIdInAndBookingTypeNot(List<Long> seatIds, BookingType bookingType);

    @Modifying
    @Query("UPDATE Seat s SET s.bookingType = :bookingType, s.userId = :userId WHERE s.id IN :ids")
    Integer updateBookingByIdIn(@Param("ids") List<Long> ids, @Param("userId") Long userId, @Param("bookingType") BookingType bookingType);

    List<Seat> findByIdInAndUserIdAndBookingType(List<Long> seatIds, Long userId, BookingType bookingType);

    List<Seat> findAllByIdIn(List<Long> ids);
}
