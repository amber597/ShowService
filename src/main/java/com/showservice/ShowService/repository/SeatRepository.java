package com.showservice.ShowService.repository;

import com.showservice.ShowService.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByShowId(Long showId);
}
