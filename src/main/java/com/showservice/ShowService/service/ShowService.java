package com.showservice.ShowService.service;

import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.model.Show;

import java.util.List;

public interface ShowService {
    List<Show> getShows(Long movieId);
    List<Seat> getSeats(Long showId);
}
