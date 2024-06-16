package com.app.gloesports.controller;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// It is a controller class that handles
// the user related requests
@RestController

public class UserController {

    // Add a user
    @Autowired
    UserServiceImpl userservice;

    @PostMapping("/saveUser")
    public UserDto saveUser(@Validated @RequestBody UserDto userDto) {
        String name= userDto.getName();

        return userservice.addUser(userDto);
    }

    //Get a user by userId

    @GetMapping("/getUserById/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userservice.getUserById(userId);
    }

}
