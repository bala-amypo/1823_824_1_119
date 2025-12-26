package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController(UserService userService, JwtUtil jwtUtil) {
    }
}
