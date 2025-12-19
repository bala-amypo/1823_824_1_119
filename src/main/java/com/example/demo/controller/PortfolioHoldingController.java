package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService portfolioHoldingService;

    public PortfolioHoldingController(PortfolioHoldingService portfolioHoldingService) {
        this.portfolioHoldingService = portfolioHoldingService;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> create(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(portfolioHoldingService.createHolding(holding));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> byPortfolio(
            @PathVariable Long portfolioId) {

        return ResponseEntity.ok(
                portfolioHoldingService.getHoldingsByPortfolio(portfolioId));
    }
}
