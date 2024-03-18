package com.example.microservice.RepositoryTest;

import com.example.microservice.AbstractIntegrationDBTest;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class UserRepositoryTest extends AbstractIntegrationDBTest {
    UserRepository userRepository;

    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void MockUser() {
        User user1 = User.builder()
                        .name("Juan")
                        .lastName("Perez")
                        .email("ramirez@gmail.com")
                        .password("1234")
                        .age(20)
                        .picture("https://www.google.com")
                        .createAt(LocalDateTime.now())
                        .enable(true)
                        .resPassword("1234")
                        .rol("user")
                        .build();
        userRepository.save(user1);

        User user2 = User.builder()
                        .name("Juan")
                        .lastName("Perez")
                        .email("ramirez2@gmail.com")
                        .password("1234")
                        .age(20)
                        .picture("https://www.google.com")
                        .createAt(LocalDateTime.now())
                        .enable(true)
                        .resPassword("1234")
                        .rol("user")
                        .build();
        userRepository.save(user2);

    }

    @Test
    void findByNameAndlastName() {
        MockUser();
        List<User> userList= userRepository.findByNameAndlastName("Juan", "Perez");
        assertThat(userList).isNotEmpty();
        assertThat(userList.get(0).getName()).isEqualTo("Juan");
    }
    @Test
    void SaveUserById() {
        User user = User.builder()
                        .name("Juan")
                        .lastName("Perez")
                        .email("skdh@hkdh.com")
                        .password("1234")
                        .age(20)
                        .picture("https://www.google.com")
                        .createAt(LocalDateTime.now())
                        .enable(true)
                        .resPassword("1234")
                        .rol("user")
                        .build();
        userRepository.save(user);
        assertThat(user.getIdUser()).isNotNull();
    }
}
