package com.example.microservice.data.services;

import com.example.microservice.data.entities.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(String creator, String destinatary, String content);

    List<Message> findAllByIdUser(Long idUser);
    List<Message> getAllMessages();
    List<Message> getAllMessagesByCreator(String creator);

    List<Message> getAllMessagesByDestinatary (String destinatary);

    List<Message> getAllMessagesByCreatorAndDestinatary(String creator, String destinatary);

    void deleteMessage(Long messageId);




}
