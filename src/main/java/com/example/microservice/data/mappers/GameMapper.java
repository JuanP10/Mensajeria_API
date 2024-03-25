package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.GameDto;
import com.example.microservice.data.entities.Game;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(
    componentModel = "spring"
)
public interface GameMapper {

}
