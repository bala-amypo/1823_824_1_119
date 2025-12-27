package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    @PostMapping
    public ResponseEntity<RiskThreshold> create(@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(riskThresholdService.createThreshold(threshold));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> update(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(riskThresholdService.updateThreshold(id, threshold));
    }

    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAll() {
        return ResponseEntity.ok(riskThresholdService.getAllThresholds());
    }
}
