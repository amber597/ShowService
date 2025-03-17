package com.showservice.ShowService.service;

import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.model.Show;
import com.showservice.ShowService.repository.SeatRepository;
import com.showservice.ShowService.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    private final SeatRepository seatRepository;

    public ShowServiceImpl(ShowRepository showRepository, SeatRepository seatRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Show> getShows(Long movieId) {
        return showRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<Seat> getSeats(Long showId) {
        return seatRepository.findAllByShowId(showId);
    }
}
