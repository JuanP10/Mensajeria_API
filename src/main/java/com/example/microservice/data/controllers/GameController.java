package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.Game;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<User> getAll(){
        return ResponseEntity.ok().body((User) this.gameService.getAll());
    }

    @GetMapping("/sport")
    public Optional<Game> getAllBySport(String sport){
        return this.gameService.findAllBySport(sport);
    }

    @GetMapping("/date")
    public Optional<Game> getAllByDate(LocalDate date){
        return this.gameService.findAllByDate(date);
    }
}
