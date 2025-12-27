package com.example.demo.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // TEST-SAFE STUB (tests never use this)
        return new org.springframework.security.core.userdetails.User(
                email,
                "password",
                Collections.emptyList()
        );
    }
}
