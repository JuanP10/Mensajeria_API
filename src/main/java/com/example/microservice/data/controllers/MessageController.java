package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.Message;
import com.example.microservice.data.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{idUser}")
    public List<Message> findAllByIdUser (@RequestBody Long idUser){
        return messageService.findAllByIdUser(idUser);
    }


    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/creator/{creator}")
    public List<Message> getAllMessagesByCreator(@PathVariable String creator) {
        return messageService.getAllMessagesByCreator(creator);
    }

    @GetMapping("/destinatary/{destinatary}")
    public List<Message> getAllMessagesByDestinatary(@PathVariable String destinatary) {
        return messageService.getAllMessagesByDestinatary(destinatary);
    }

    @GetMapping("/creator/{creator}/destinatary/{destinatary}")
    public List<Message> getMessagesByCreatorAndDestinatary(@PathVariable String creator, @PathVariable String destinatary) {
        return messageService.getAllMessagesByCreatorAndDestinatary(creator, destinatary);
    }

    @DeleteMapping("/{idMessage}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long idMessage) {
        messageService.deleteMessage(idMessage);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
