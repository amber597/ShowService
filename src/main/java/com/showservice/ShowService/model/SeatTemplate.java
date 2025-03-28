package com.showservice.ShowService.model;

import com.showservice.ShowService.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seat_templates")
@Data
@NoArgsConstructor
public class SeatTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String seatName;
    private SeatType seatType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    public SeatTemplate(String seatName, SeatType seatType, Theater theater) {
        this.seatName = seatName;
        this.seatType = seatType;
        this.theater = theater;
    }
}
