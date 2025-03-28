package com.showservice.ShowService.model;

import com.showservice.ShowService.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Data
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<SeatTemplate> seats;

    public Theater(String name, String address) {
        this.name = name;
        this.address = address;
        this.seats = new ArrayList<>();

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
                SeatTemplate seat = new SeatTemplate(seatName, seatType, this);
                seats.add(seat);
            }
        }
    }

}
