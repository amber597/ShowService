package com.showservice.ShowService.service;

import com.showservice.ShowService.dto.AddTheaterRequest;
import com.showservice.ShowService.model.Theater;

public interface TheaterService {
    public Theater findById(Long theaterId);
    public void addTheater(AddTheaterRequest theaterRequest);
}
