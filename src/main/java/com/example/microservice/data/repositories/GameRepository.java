package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Override
    Optional<Game> findById(Long along);


    Optional<Game> findAllBySport(String sport);

    Optional<Game> findAllByByDate(LocalDate date);

}
