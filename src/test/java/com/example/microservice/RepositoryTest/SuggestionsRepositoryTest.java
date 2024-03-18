package com.example.microservice.RepositoryTest;

import com.example.microservice.AbstractIntegrationDBTest;
import com.example.microservice.data.entities.Suggestion;
import com.example.microservice.data.repositories.SuggestionsRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class SuggestionsRepositoryTest extends AbstractIntegrationDBTest {
    SuggestionsRepository suggestionsRepository;

    @Autowired
    public void setSuggestionsRepository(SuggestionsRepository suggestionsRepository) {
        this.suggestionsRepository = suggestionsRepository;
    }

    @BeforeEach
    void setUp() {
        suggestionsRepository.deleteAll();
    }

    @Test
    void testSaveSuggestionId() {
        Suggestion suggestion = Suggestion.builder()
                .createAt(LocalDateTime.now())
                .description("Juego")
                .build();
        suggestionsRepository.save(suggestion);
        Assert.assertNotNull(suggestion.getId());
    }
}
