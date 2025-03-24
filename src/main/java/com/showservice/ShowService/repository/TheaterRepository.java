package com.showservice.ShowService.repository;

import com.showservice.ShowService.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
