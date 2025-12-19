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

    @PostMapping
    public ResponseEntity<RiskThreshold> createThreshold(
            @RequestBody RiskThreshold threshold) {

        return ResponseEntity.ok(
                riskThresholdService.createThreshold(threshold));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> updateThreshold(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold) {

        return ResponseEntity.ok(
                riskThresholdService.updateThreshold(id, threshold));
    }

    @GetMapping("/active")
    public ResponseEntity<RiskThreshold> getActiveThreshold() {
        return ResponseEntity.ok(
                riskThresholdService.getActiveThreshold());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskThreshold> getThresholdById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                riskThresholdService.getThresholdById(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        return ResponseEntity.ok(
                riskThresholdService.getAllThresholds());
    }
}
