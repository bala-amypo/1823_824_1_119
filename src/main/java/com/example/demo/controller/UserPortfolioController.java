package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;

@RestController
@RequestMapping("/api/portfolios")
@Tag(name = "User Portfolios")
public class UserPortfolioController {

    private final UserPortfolioService userPortfolioService;

    public UserPortfolioController(
            UserPortfolioService userPortfolioService) {

        this.userPortfolioService = userPortfolioService;
    }

    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(
            @RequestBody UserPortfolio portfolio) {

        return ResponseEntity.ok(
                userPortfolioService.createPortfolio(portfolio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPortfolio> updatePortfolio(
            @PathVariable Long id,
            @RequestBody UserPortfolio portfolio) {

        return ResponseEntity.ok(
                userPortfolioService.updatePortfolio(id, portfolio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolioById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userPortfolioService.getPortfolioById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> getPortfoliosByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                userPortfolioService.getPortfoliosByUser(userId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivatePortfolio(
            @PathVariable Long id) {

        userPortfolioService.deactivatePortfolio(id);
        return ResponseEntity.ok().build();
    }
}
