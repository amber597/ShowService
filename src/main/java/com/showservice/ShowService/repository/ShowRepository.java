package com.showservice.ShowService.repository;

import com.showservice.ShowService.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findAllByMovieId(Long movieId);
}
