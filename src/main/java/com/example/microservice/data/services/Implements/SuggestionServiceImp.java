package com.example.microservice.data.services.Implements;

import com.example.microservice.data.mappers.SuggestionMapper;
import com.example.microservice.data.repositories.SuggestionsRepository;
import com.example.microservice.data.services.SuggestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service

public class SuggestionServiceImp implements SuggestionService {
    private final SuggestionsRepository suggestionsRepository;
    private final SuggestionMapper suggestionMapper;
}
