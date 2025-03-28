package com.showservice.ShowService.controller;

import com.showservice.ShowService.dto.AddShowRequest;
import com.showservice.ShowService.exception.InvalidSeatIdsException;
import com.showservice.ShowService.exception.SeatsUnavailableException;
import com.showservice.ShowService.exception.TheaterNotFoundException;
import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.model.Show;
import com.showservice.ShowService.service.SeatService;
import com.showservice.ShowService.service.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;
    private final SeatService seatService;

    public ShowController(ShowService showService, SeatService seatService) {
        this.showService = showService;
        this.seatService = seatService;
    }

    @GetMapping()
    public List<Show> getShows(@RequestParam Long movieId) {
        return showService.getShows(movieId);
    }

    @GetMapping("/{showId}/seats")
    public List<Seat> getSeats(@PathVariable Long showId) {
        return showService.getSeats(showId);
    }

    @GetMapping("/confirm-booking")
    public ResponseEntity<String> confirmBooking(@RequestParam Long userId, @RequestParam List<Long> seatIds) {

            seatService.confirmBooking(userId, seatIds);
            return ResponseEntity.ok("Booking confirmed");

    }

    @GetMapping("/book-seats")
    public ResponseEntity<String> bookSeats(@RequestParam Long userId,@RequestParam List<Long> seatIds) {
            seatService.bookSeats(userId, seatIds);
            return ResponseEntity.ok("Seats confirmed");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody AddShowRequest showRequest) {
            this.showService.addShow(showRequest);
            return ResponseEntity.ok("Added Show");
    }
}
