package com.example.microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // la prueba se ejecutará en un puerto aleatorio.
class MicroServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
