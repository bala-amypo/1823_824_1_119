package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> addHolding(
            @RequestBody PortfolioHolding holding) {

        return new ResponseEntity<>(
                service.addHolding(holding),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getHoldingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getHoldingById(id));
    }
}
