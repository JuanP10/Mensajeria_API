package com.example.microservice.data.services;

import com.example.microservice.data.entities.Game;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GameService {
    Game createGame(String creator, String sport, String city, String province, LocalDate date, LocalDateTime startTime, Integer participants, Integer subs, String comments);
    List<Game> getAllGames();
    Optional<Game> getGamesByCityAndDate(String city, LocalDate date);

    void deleteGame(Long gameId);

}
