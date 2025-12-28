package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 🔐 SECRET KEY (must be at least 256 bits for HS256)
    private static final String SECRET_KEY =
            "mySuperSecretKeyForJwtSigning1234567890";

    // ⏳ TOKEN VALIDITY (1 day)
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    private final Key key;

    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /* ===================== TOKEN GENERATION ===================== */

    public String generateToken(String email, String role, Long userId) {

        return Jwts.builder()
                .setSubject(email)                // username / email
                .claim("role", role)               // custom claim
                .claim("userId", userId)           // custom claim
                .setIssuedAt(new Date())           // iat
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION_TIME)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /* ===================== TOKEN VALIDATION ===================== */

    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /* ===================== EXTRACT DATA ===================== */

    public String extractEmail(String token) {
        return parseClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return parseClaims(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseClaims(token).get("userId", Long.class);
    }

    /* ===================== INTERNAL ===================== */

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
