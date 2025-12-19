package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> create(@RequestBody PortfolioHolding h) {
        return ResponseEntity.ok(service.createHolding(h));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> update(
            @PathVariable Long id,
            @RequestBody PortfolioHolding h) {
        return ResponseEntity.ok(service.updateHolding(id, h));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHoldingById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> byPortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(service.getHoldingsByPortfolio(portfolioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteHolding(id);
        return ResponseEntity.ok().build();
    }
}
