package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Portfolio Holdings", description = "Portfolio holding operations")
public class PortfolioHoldingController {
    
    @Autowired(required = false)
    private PortfolioHoldingService holdingService;
    
    @PostMapping
    @Operation(summary = "Create holding")
    public ResponseEntity<PortfolioHolding> createHolding(@RequestBody PortfolioHolding holding) {
        if (holdingService != null) {
            return ResponseEntity.ok(holdingService.createHolding(holding));
        }
        return ResponseEntity.ok(holding);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update holding")
    public ResponseEntity<PortfolioHolding> updateHolding(@PathVariable Long id, @RequestBody PortfolioHolding holding) {
        if (holdingService != null) {
            return ResponseEntity.ok(holdingService.updateHolding(id, holding));
        }
        return ResponseEntity.ok(holding);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get holding")
    public ResponseEntity<PortfolioHolding> getHolding(@PathVariable Long id) {
        if (holdingService != null) {
            return ResponseEntity.ok(holdingService.getHoldingById(id));
        }
        return ResponseEntity.ok(new PortfolioHolding());
    }

    @GetMapping("/portfolio/{portfolioId}")
    @Operation(summary = "Get holdings by portfolio")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        if (holdingService != null) {
            return ResponseEntity.ok(holdingService.getHoldingsByPortfolio(portfolioId));
        }
        return ResponseEntity.ok(List.of());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete holding")
    public ResponseEntity<Void> deleteHolding(@PathVariable Long id) {
        if (holdingService != null) {
            holdingService.deleteHolding(id);
        }
        return ResponseEntity.ok().build();
    }
}