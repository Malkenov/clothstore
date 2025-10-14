package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.UserDto;
import com.example.clothstore.clothstore.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
