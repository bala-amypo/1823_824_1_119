package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService userPortfolioService;

    public UserPortfolioController(UserPortfolioService userPortfolioService) {
        this.userPortfolioService = userPortfolioService;
    }

    @PostMapping
    public ResponseEntity<UserPortfolio> create(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(userPortfolioService.createPortfolio(portfolio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> get(@PathVariable Long id) {
        return ResponseEntity.ok(userPortfolioService.getPortfolioById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userPortfolioService.getPortfoliosByUser(userId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        userPortfolioService.deactivatePortfolio(id);
        return ResponseEntity.ok().build();
    }
}
