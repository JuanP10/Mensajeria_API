package com.example.microservice.RepositoryTest;

import com.example.microservice.AbstractIntegrationDBTest;
import com.example.microservice.data.entities.Message;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.repositories.MessageRepository;
import com.example.microservice.data.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class MessageRepositoryTest extends AbstractIntegrationDBTest {
    MessageRepository messageRepository;
    UserRepository userRepository;

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository, UserRepository userRepository) {
            this.messageRepository = messageRepository;
            this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {
        messageRepository.deleteAll();
        userRepository.deleteAll();
    }

    Message saveMessage() {
        User user = User.builder()
                        .name("Juan")
                        .lastName("Perez")
                        .email("ramirezgutierrez32@gmail.com")
                        .password("1234")
                        .age(20)
                        .picture("https://www.google.com")
                        .createAt(LocalDateTime.now())
                        .enable(true)
                        .resPassword("1234")
                        .rol("user")
                        .build();
        userRepository.save(user);
        Message message = Message.builder()
                                .content("Hola")
                                .createAt(LocalDateTime.now())
                                .creator(user.getName())
                                .user(user)
                                .destinatary("Juan")
                                .build();
        return messageRepository.save(message);
    }

    @Test
    void testSaveMessageId() {
        Message message = saveMessage();
        Assert.assertNotNull(message.getIdMessage());
    }

    @Test
    void findUserById(){
        Message message = saveMessage();
        List<Message> messages = messageRepository.findAllByUserId(message.getUser().getIdUser());
        assertThat(messageRepository.findAllByUserId(message.getUser().getIdUser())).isNotEmpty();
        assertThat(messages.get(0).getUser().getIdUser()).isEqualTo(message.getUser().getIdUser());
    }
}

