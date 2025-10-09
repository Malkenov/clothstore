package com.example.clothstore.clothstore.service;

import com.example.clothstore.clothstore.entity.User;

import com.example.clothstore.clothstore.exception.BadRequestException;
import com.example.clothstore.clothstore.exception.NotFoundException;
import com.example.clothstore.clothstore.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Нету такого пользователя"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long user_id, User user) {
        User u = userRepository.findById(user_id)
                .orElseThrow(() -> new BadRequestException("Нету этого пользователя"));
        u.setName(user.getName());
        return userRepository.save(u);
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("Нету такого пользователя!");
        }
    }
}
