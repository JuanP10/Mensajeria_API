package com.example.microservice.data.services;

import com.example.microservice.data.entities.Game;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameService {
    Optional<Game> findAllBySport (String sport);

    Optional<Game> findAllByDate(LocalDate date);

    List<Game> getAll();



}
