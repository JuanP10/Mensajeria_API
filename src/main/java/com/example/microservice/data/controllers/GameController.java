package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.Game;
import com.example.microservice.data.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game.getCreator(), game.getSport(), game.getCity(), game.getProvince(), LocalDate.from(game.getDate()), game.getStartTime(), game.getParticipants(), game.getSubs(), game.getComents());
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/city/{city}/date/{date}")
    public Optional<Game> getGamesByCityAndDate(@PathVariable String city, @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return gameService.getGamesByCityAndDate(city, localDate);
    }

    @DeleteMapping
    public void deleteGame(@RequestParam Long gameId) {
        gameService.deleteGame(gameId);
    }
}
