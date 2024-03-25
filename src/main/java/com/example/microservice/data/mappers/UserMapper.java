package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {

    User userDtoToUser (UserDtoSend userDto);
    UserDtoSend userToUserDto (User user);
}
