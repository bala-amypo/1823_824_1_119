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
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

@RestController
@RequestMapping("/api/risk-thresholds")
@Tag(name = "Risk Thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    /**
     * GET /api/risk-thresholds/active
     * Returns the currently active risk threshold
     */
    @GetMapping("/active")
    public ResponseEntity<RiskThreshold> getActiveThreshold() {
        return ResponseEntity.ok(riskThresholdService.getActiveThreshold());
    }
}
