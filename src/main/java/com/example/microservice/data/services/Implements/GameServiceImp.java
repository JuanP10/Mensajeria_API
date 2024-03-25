package com.example.microservice.data.services.Implements;

import com.example.microservice.data.entities.Game;
import com.example.microservice.data.mappers.GameMapper;
import com.example.microservice.data.repositories.GameRepository;
import com.example.microservice.data.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameServiceImp implements GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Override
    public Optional<Game> findAllBySport(String sport) {
        return this.gameRepository.findAllBySport(sport);
    }


    @Override
    public Optional<Game> findAllByDate(LocalDate date) {
        return this.gameRepository.findAllByByDate(LocalDate.parse(String.valueOf(date)));
    }

    @Override
    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }


}
