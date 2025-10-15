package com.example.clothstore.clothstore.service;

import com.example.clothstore.clothstore.dto.mapper.UserMapper;
import com.example.clothstore.clothstore.dto.mapper.request.UserDto;
import com.example.clothstore.clothstore.dto.mapper.responce.UserResponseDto;
import com.example.clothstore.clothstore.entity.User;

import com.example.clothstore.clothstore.exception.BadRequestException;
import com.example.clothstore.clothstore.exception.NotFoundException;
import com.example.clothstore.clothstore.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponseDto> getAll() {
        List<User> user = userRepository.findAll();
        return user.stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto getById(Long user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new BadRequestException("Нету такого пользователя"));
        return userMapper.toDto(user);
    }

    @Transactional
    public UserResponseDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Transactional
    public UserResponseDto updateUser(Long user_id, UserDto userDto) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new BadRequestException("Нету этого пользователя"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("Нету такого пользователя!");
        }
    }
}
