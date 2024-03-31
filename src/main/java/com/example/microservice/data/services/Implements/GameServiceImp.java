package com.example.microservice.data.services.Implements;

import com.example.microservice.data.entities.Game;
import com.example.microservice.data.mappers.GameMapper;
import com.example.microservice.data.repositories.GameRepository;
import com.example.microservice.data.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameServiceImp implements GameService {
    private final GameRepository gameRepository;

    @Override
    public Game createGame(String creator, String sport, String city, String province, LocalDate date, LocalDateTime startTime, Integer participants, Integer subs, String comments) {
        Game newGame = new Game();
        newGame.setCreator(creator);
        newGame.setSport(sport);
        newGame.setCity(city);
        newGame.setProvince(province);
        newGame.setDate(date);
        newGame.setStartTime(startTime);
        newGame.setParticipants(participants);
        newGame.setSubs(subs);
        newGame.setComents(comments);
        return gameRepository.save(newGame);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> getGamesByCityAndDate(String city, LocalDate date) {
        return gameRepository.findAllByCityAndDate(city, date);
    }

    @Override
    public void deleteGame(Long idGame) {
        gameRepository.deleteById(idGame);
    }
}
