package com.example.microservice.data.services;

import com.example.microservice.data.entities.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(String creator, String destinatary, String content);
    List<Message> getAllMessages();
    List<Message> getMessagesByCreator(String creator);

    List<Message> getMessagesByDestinatary(String destinatary);

    void deleteMessage(Long messageId);
}
