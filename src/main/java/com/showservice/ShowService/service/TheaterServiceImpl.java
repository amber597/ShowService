package com.showservice.ShowService.service;

import com.showservice.ShowService.dto.AddTheaterRequest;
import com.showservice.ShowService.model.Theater;
import com.showservice.ShowService.repository.TheaterRepository;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public Theater findById(Long theaterId) {
        return theaterRepository.findById(theaterId).get();
    }

    @Override
    public void addTheater(AddTheaterRequest theaterRequest) {
        theaterRepository.save(new Theater(theaterRequest.getName(), theaterRequest.getAddress()));
    }
}
