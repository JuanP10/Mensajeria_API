package com.example.microservice.data.services.Implements;

import com.example.microservice.data.entities.Message;
import com.example.microservice.data.repositories.MessageRepository;
import com.example.microservice.data.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public Message createMessage(String creator, String destinatary, String content) {
        Message newMessage = new Message();
        newMessage.setCreator(creator);
        newMessage.setDestinatary(destinatary);
        newMessage.setContent(content);
        return messageRepository.save(newMessage);
    }

    @Override
    public List<Message> findAllByIdUser(Long idUser) {
        return this.messageRepository.findAllByUserId(idUser);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getAllMessagesByCreator(String creator) {
        return this.messageRepository.findAllByCreator(creator);
    }

    @Override
    public List<Message> getAllMessagesByDestinatary (String destinatary) {
        return this.messageRepository.findAllByDestinatary(destinatary);
    }

    @Override
    public  List<Message> getAllMessagesByCreatorAndDestinatary(String creator, String destinatary) {
        return this.messageRepository.findAllByCreatorAndDestinatary(creator, destinatary);
    }

    @Override
    public void deleteMessage(Long idMessage) {
        messageRepository.deleteById(idMessage);
    }
}
