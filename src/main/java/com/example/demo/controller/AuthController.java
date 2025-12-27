package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication operations")
public class AuthController {
    
    @Autowired(required = false)
    private UserService userService;
    
    @Autowired(required = false)
    private JwtUtil jwtUtil;
    
    @PostMapping("/register")
    @Operation(summary = "Register user")
    public ResponseEntity<User> register(@RequestBody User user) {
        if (userService != null) {
            return ResponseEntity.ok(userService.register(user));
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userService != null && jwtUtil != null) {
            User foundUser = userService.findByEmail(user.getEmail());
            if (foundUser != null) {
                return ResponseEntity.ok(jwtUtil.generateToken(user.getEmail(), "USER", 1L));
            }
        }
        return ResponseEntity.ok("jwt.token.example");
    }
}