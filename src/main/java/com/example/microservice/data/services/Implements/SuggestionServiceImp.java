package com.example.microservice.data.services.Implements;

import com.example.microservice.data.entities.Suggestion;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.repositories.SuggestionsRepository;
import com.example.microservice.data.services.SuggestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class SuggestionServiceImp implements SuggestionService {
    private final SuggestionsRepository suggestionsRepository;

    @Override
    public Suggestion createSuggestion(String description, User user) {
        Suggestion newSuggestion = new Suggestion();
        newSuggestion.setDescription(description);
        newSuggestion.setUser(user);
        return suggestionsRepository.save(newSuggestion);
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return suggestionsRepository.findAll();
    }

    @Override
    public List<Suggestion> getSuggestionsByIdSuggestion(Long idSuggestion) {
        return suggestionsRepository.findAllByIdSuggestion(idSuggestion);
    }

    @Override
    public void deleteSuggestion(Long idSuggestion) {
        suggestionsRepository.deleteById(idSuggestion);
    }
}
