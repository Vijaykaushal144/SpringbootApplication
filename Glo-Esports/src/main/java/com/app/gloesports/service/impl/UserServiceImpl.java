package com.app.gloesports.service.impl;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.User;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.UserService;
import com.app.gloesports.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// make this into a service layer for User entity
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDTO) {

        User user = Mapper.mapToUserEntity(userDTO);
       User saveUser= userRepository.save(user);
        UserDto savedUserDTO = Mapper.mapToUserDto(saveUser);
        return savedUserDTO;

    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw  new ResourceNotFoundException("User","Id",+userId);
        }

        return Mapper.mapToUserDto(user.get());
    }
}
