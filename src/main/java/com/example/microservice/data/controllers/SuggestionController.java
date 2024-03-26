package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.Suggestion;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.services.SuggestionService;
import com.example.microservice.data.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {
    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping
    public Suggestion createSuggestion(@RequestBody Suggestion suggestion) {
        return suggestionService.createSuggestion(suggestion.getDescription(), suggestion.getUser());
    }

    @GetMapping
    public List<Suggestion> getAllSuggestions() {
        return suggestionService.getAllSuggestions();
    }

    @GetMapping("/user/{userId}")
    public List<Suggestion> getSuggestionsByUser(@PathVariable Long userId) {
        return suggestionService.getSuggestionsByUser(userId);
    }

    @DeleteMapping
    public void deleteSuggestion(@RequestParam Long suggestionId) {
        suggestionService.deleteSuggestion(suggestionId);
    }
}
