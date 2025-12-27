package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for APIs
            .csrf(csrf -> csrf.disable())

            // Allow Swagger & Auth APIs without login
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/auth/**"
                ).permitAll()
                .anyRequest().permitAll()
            )

            // Disable default login page
            .formLogin(form -> form.disable())

            // Disable HTTP basic auth
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
