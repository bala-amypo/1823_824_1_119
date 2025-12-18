package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User register(User user) {

        repository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email already exists");
                });

        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
