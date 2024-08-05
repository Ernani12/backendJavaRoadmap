package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserLoginDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        // Registration logic (e.g., password encoding, saving user)
        return userRepository.save(user);
    }

    public String login(UserLoginDto loginDto) {
        // Login logic (e.g., authentication, token generation)
        return "token";
    }
}
