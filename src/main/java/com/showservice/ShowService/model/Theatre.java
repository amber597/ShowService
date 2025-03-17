package com.showservice.ShowService.model;

import com.showservice.ShowService.enuns.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theatres")
@Data
@NoArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Seat> seats;

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;

        for(char c = 'A'; c <= 'Z'; c++) {
            for(int i = 1; i <= 16; i++) {
                String seatName = String.valueOf(c) + i;
                SeatType seatType;
                if(c >= 'A' && c <= 'D') {
                    seatType = SeatType.FRONT;
                }
                else if(c >= 'D' && c <= 'U') {
                    seatType = SeatType.MIDDLE;
                }
                else {
                    seatType = SeatType.BACK;
                }
                Seat seat = new Seat(seatName, seatType, this);
            }
        }
    }

}
