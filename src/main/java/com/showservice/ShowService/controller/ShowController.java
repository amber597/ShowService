package com.showservice.ShowService.controller;

import com.showservice.ShowService.dto.AddShowRequest;
import com.showservice.ShowService.exeption.TheaterNotFoundException;
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

    @GetMapping("/book-seats")
    public boolean bookSeat(@RequestParam Long userId, @RequestParam List<Long> seatIds) {
        for(Long seatId:seatIds) {
            if (!seatService.seatAvailable(seatId)) {
                return false;
            }
        }
        return seatService.bookSeats(userId, seatIds);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody AddShowRequest showRequest) {
        try {
            this.showService.addShow(showRequest);
            return ResponseEntity.ok("Added Show");
        } catch (TheaterNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Coudn't save the Show");
        }
    }
}
