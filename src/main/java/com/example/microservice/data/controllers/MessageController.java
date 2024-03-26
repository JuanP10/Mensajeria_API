package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.Message;
import com.example.microservice.data.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message.getCreator(), message.getDestinatary(), message.getContent());
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/creator/{creator}")
    public List<Message> getMessagesByCreator(@PathVariable String creator) {
        return messageService.getMessagesByCreator(creator);
    }

    @DeleteMapping
    public void deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
    }
}
