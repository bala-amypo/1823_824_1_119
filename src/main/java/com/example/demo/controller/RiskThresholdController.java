package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    @Autowired
    private RiskThresholdService thresholdService;

    @PostMapping
    public RiskThreshold createThreshold(@RequestBody RiskThreshold threshold) {
        return thresholdService.createThreshold(threshold);
    }

    @PutMapping("/{id}")
    public RiskThreshold updateThreshold(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold) {
        return thresholdService.updateThreshold(id, threshold);
    }

    @GetMapping("/active")
    public RiskThreshold getActiveThreshold() {
        return thresholdService.getActiveThreshold();
    }

    @GetMapping("/{id}")
    public RiskThreshold getThresholdById(@PathVariable Long id) {
        return thresholdService.getThresholdById(id);
    }

    @GetMapping
    public List<RiskThreshold> getAllThresholds() {
        return thresholdService.getAllThresholds();
    }
}
