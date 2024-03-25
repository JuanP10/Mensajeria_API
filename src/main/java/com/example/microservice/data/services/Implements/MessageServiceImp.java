package com.example.microservice.data.services.Implements;

import com.example.microservice.data.mappers.MessageMapper;
import com.example.microservice.data.repositories.MessageRepository;
import com.example.microservice.data.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
}
