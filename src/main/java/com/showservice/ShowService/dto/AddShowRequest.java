package com.showservice.ShowService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddShowRequest {
    private Long movieId;
    private Long theaterId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
