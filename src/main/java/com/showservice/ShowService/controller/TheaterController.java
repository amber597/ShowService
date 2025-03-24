package com.showservice.ShowService.controller;

import com.showservice.ShowService.dto.AddTheaterRequest;
import com.showservice.ShowService.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/theaters")
public class TheaterController {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterRequest theaterRequest) {
        theaterService.addTheater(theaterRequest);
        return ResponseEntity.ok("Added theater");
    }
}
