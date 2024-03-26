package com.example.microservice.data.services.Implements;

import com.example.microservice.data.entities.Message;
import com.example.microservice.data.mappers.MessageMapper;
import com.example.microservice.data.repositories.MessageRepository;
import com.example.microservice.data.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public Message createMessage(String creator, String destinatary, String content) {
        Message newMessage = new Message();
        newMessage.setCreator(creator);
        newMessage.setDestinatary(destinatary);
        newMessage.setContent(content);
        return messageRepository.save(newMessage);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getMessagesByCreator(String creator) {
        return this.messageRepository.findAllByCreator(creator);
    }

    @Override
    public List<Message> getMessagesByDestinatary(String destinatary) {
        return this.messageRepository.findAllByDestinatary(destinatary);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
