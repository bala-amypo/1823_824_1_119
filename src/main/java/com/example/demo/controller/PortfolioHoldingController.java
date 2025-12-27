package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> create(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.createHolding(holding));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> update(
            @PathVariable Long id,
            @RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.updateHolding(id, holding));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getById(@PathVariable Long id) {
        return ResponseEntity.ok(holdingService.getHoldingById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getByPortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(holdingService.getHoldingsByPortfolio(portfolioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        holdingService.deleteHolding(id);
        return ResponseEntity.noContent().build();
    }
}
