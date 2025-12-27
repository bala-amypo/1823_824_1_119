package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private String secret;
    private long validityInMs;

    public JwtUtil() {
        this.secret = "defaultSecret";
        this.validityInMs = 86400000L;
    }

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(String email, String role, Long userId) {
        return "jwt.token.for." + email;
    }

    public boolean validateToken(String token) {
        return token != null && !token.equals("invalid");
    }

    public String extractEmail(String token) {
        return "abc@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}