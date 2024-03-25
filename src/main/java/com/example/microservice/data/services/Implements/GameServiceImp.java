package com.example.microservice.data.services.Implements;

import com.example.microservice.data.mappers.GameMapper;
import com.example.microservice.data.repositories.GameRepository;
import com.example.microservice.data.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GameServiceImp implements GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
}
