package com.example.microservice.RepositoryTest;
import com.example.microservice.AbstractIntegrationDBTest;
import com.example.microservice.data.entities.Game;
import com.example.microservice.data.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class GameRepositoryTest extends AbstractIntegrationDBTest {
    GameRepository gameRepository;

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @BeforeEach
    void setUp() {
        gameRepository.deleteAll();
    }

    void mockGame() {
        Game game = Game.builder()
                        .city("Bogota")
                        .coments("Juego")
                        .date(LocalDate.parse("2021-10-10"))
                        .sport("Futbol")
                        .subs(0)
                        .participants(0)
                        .creator("Juan")
                        .province("Cundinamarca")
                        .startTime(LocalDateTime.now())
                        .build();

        gameRepository.save(game);
    }

    @Test
    void testSaveGameId() {
        mockGame();
        Game game = gameRepository.findAll().get(0);
        assertNotNull(game.getIdGame());
    }

}
