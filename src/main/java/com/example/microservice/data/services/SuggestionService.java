package com.example.microservice.data.services;

import com.example.microservice.data.entities.Suggestion;
import com.example.microservice.data.entities.User;

import java.util.List;

public interface SuggestionService {
    Suggestion createSuggestion(String description, User user);
    List<Suggestion> getAllSuggestions();
    List<Suggestion> getSuggestionsByUser(Long id);

    void deleteSuggestion(Long suggestionId);
}
