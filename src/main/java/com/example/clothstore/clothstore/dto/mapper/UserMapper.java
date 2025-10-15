package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.mapper.request.UserDto;
import com.example.clothstore.clothstore.dto.mapper.responce.UserResponseDto;
import com.example.clothstore.clothstore.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserResponseDto toDto(User entity);
}
