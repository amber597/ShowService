package com.showservice.ShowService.model;

import com.showservice.ShowService.enums.BookingType;
import com.showservice.ShowService.enums.SeatType;
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
    private BookingType bookingType;

    private Long userId;
    private Long showId;
    private Long theaterId;


    public Seat(String seatName, SeatType seatType, Long theaterId, Long showId) {
        this.seatName = seatName;
        this.seatType = seatType;
        this.bookingType = BookingType.AVAILABLE;
        this.theaterId = theaterId;
        this.showId = showId;
    };

    public Seat(String seatName, SeatType seatType, Long theaterId) {
        this(seatName, seatType, theaterId, null);
    }

}
