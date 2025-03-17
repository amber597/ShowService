package com.showservice.ShowService.controller;

import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.model.Show;
import com.showservice.ShowService.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows/")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping()
    public List<Show> getShows(@RequestParam Long movieId) {
        return showService.getShows(movieId);
    }

    @GetMapping("{showId}/seats")
    public List<Seat> getSeats(@PathVariable Long showId) {
        return showService.getSeats(showId);
    }
}
