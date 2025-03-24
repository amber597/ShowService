package com.showservice.ShowService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieId;
    private Long theaterId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Show(Long movieId, Long theaterId, LocalDateTime startTime, LocalDateTime endTime) {
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
