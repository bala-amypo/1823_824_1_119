package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskThreshold> createThreshold(
            @RequestBody RiskThreshold threshold) {

        return new ResponseEntity<>(
                service.createThreshold(threshold),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/active")
    public ResponseEntity<RiskThreshold> getActiveThreshold() {
        return ResponseEntity.ok(service.getActiveThreshold());
    }
}
