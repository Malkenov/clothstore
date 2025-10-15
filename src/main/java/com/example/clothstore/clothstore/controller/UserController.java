package com.example.clothstore.clothstore.controller;

import com.example.clothstore.clothstore.dto.mapper.request.UserDto;
import com.example.clothstore.clothstore.dto.mapper.responce.UserResponseDto;
import com.example.clothstore.clothstore.entity.User;
import com.example.clothstore.clothstore.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/{register}")
    public UserResponseDto postUser(@RequestBody UserDto user){
        return userService.addUser(user);
    }

    @PutMapping("/{edit}")
    public UserResponseDto putUser(
            @PathVariable Long user_id,
            @RequestBody UserDto user){
        return userService.updateUser(user_id,user);
    }

    @DeleteMapping("/{remove}")
    public void removeUser(Long id){
        userService.deleteUser(id);
    }
}
