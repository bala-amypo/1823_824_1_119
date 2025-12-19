package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Portfolio Holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService portfolioHoldingService;

    public PortfolioHoldingController(
            PortfolioHoldingService portfolioHoldingService) {

        this.portfolioHoldingService = portfolioHoldingService;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> createHolding(
            @RequestBody PortfolioHolding holding) {

        return ResponseEntity.ok(
                portfolioHoldingService.createHolding(holding));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> updateHolding(
            @PathVariable Long id,
            @RequestBody PortfolioHolding holding) {

        return ResponseEntity.ok(
                portfolioHoldingService.updateHolding(id, holding));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getHoldingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                portfolioHoldingService.getHoldingById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(
            @PathVariable Long portfolioId) {

        return ResponseEntity.ok(
                portfolioHoldingService.getHoldingsByPortfolio(portfolioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHolding(
            @PathVariable Long id) {

        portfolioHoldingService.deleteHolding(id);
        return ResponseEntity.ok().build();
    }
}
