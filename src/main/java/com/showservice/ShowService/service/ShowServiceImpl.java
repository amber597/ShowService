package com.showservice.ShowService.service;

import com.showservice.ShowService.dto.AddShowRequest;
import com.showservice.ShowService.exeption.TheaterNotFoundException;
import com.showservice.ShowService.model.Seat;
import com.showservice.ShowService.model.SeatTemplate;
import com.showservice.ShowService.model.Show;
import com.showservice.ShowService.model.Theater;
import com.showservice.ShowService.repository.SeatRepository;
import com.showservice.ShowService.repository.ShowRepository;
import com.showservice.ShowService.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    private final SeatRepository seatRepository;

    private final TheaterRepository theaterRepository;

    public ShowServiceImpl(ShowRepository showRepository, SeatRepository seatRepository, TheaterRepository theaterRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.theaterRepository = theaterRepository;
    }

    @Override
    public List<Show> getShows(Long movieId) {
        return showRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<Seat> getSeats(Long showId) {
        return seatRepository.findAllByShowId(showId);
    }

    @Override
    public void addShow(AddShowRequest showRequest) {
        Show show = new Show(showRequest.getMovieId(), showRequest.getTheaterId(), showRequest.getStartTime(), showRequest.getEndTime());

        Long theaterId = showRequest.getTheaterId();
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new TheaterNotFoundException(theaterId));

        final Show savedShow = showRepository.save(show);

        List<SeatTemplate> seatTemplates = theater.getSeats();
        List <Seat> seats = seatTemplates.stream().map(seat -> new Seat(seat.getSeatName(), seat.getSeatType(), theaterId, savedShow.getId())).toList();

        seatRepository.saveAll(seats);

    }
}
