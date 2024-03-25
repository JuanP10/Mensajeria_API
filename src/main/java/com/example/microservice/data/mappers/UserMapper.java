package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.UserDto;
import com.example.microservice.data.entities.User;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {

    User userDtoToUser (UserDto userDto);
    UserDto userToUserDto (User user);
}
