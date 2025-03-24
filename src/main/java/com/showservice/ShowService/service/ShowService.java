package com.showservice.ShowService.service;

import com.showservice.ShowService.dto.AddShowRequest;
import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.model.Show;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowService {
    public List<Show> getShows(Long movieId);
    public List<Seat> getSeats(Long showId);
    public void addShow(AddShowRequest showRequest);

}
