package com.showservice.ShowService.model;

import com.showservice.ShowService.enuns.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatName;
    private SeatType seatType;
    private boolean isBooked;

    private Long userId;
    private Long showId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    public Seat(String seatName, SeatType seatType, Theatre theatre) {
        this.seatName = seatName;
        this.seatType = seatType;
        this.isBooked = false;
        this.theatre = theatre;
    };

}
