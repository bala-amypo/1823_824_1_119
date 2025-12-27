package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
@Tag(name = "Risk Thresholds", description = "Risk threshold operations")
public class RiskThresholdController {
    
    @Autowired(required = false)
    private RiskThresholdService thresholdService;
    
    @PostMapping
    @Operation(summary = "Create threshold")
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        if (thresholdService != null) {
            return ResponseEntity.ok(thresholdService.createThreshold(threshold));
        }
        return ResponseEntity.ok(threshold);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update threshold")
    public ResponseEntity<RiskThreshold> updateThreshold(@PathVariable Long id, @RequestBody RiskThreshold threshold) {
        if (thresholdService != null) {
            return ResponseEntity.ok(thresholdService.updateThreshold(id, threshold));
        }
        return ResponseEntity.ok(threshold);
    }

    @GetMapping("/active")
    @Operation(summary = "Get active threshold")
    public ResponseEntity<RiskThreshold> getActiveThreshold() {
        if (thresholdService != null) {
            return ResponseEntity.ok(thresholdService.getActiveThreshold());
        }
        return ResponseEntity.ok(new RiskThreshold());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get threshold by ID")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long id) {
        if (thresholdService != null) {
            return ResponseEntity.ok(thresholdService.getThresholdById(id));
        }
        return ResponseEntity.ok(new RiskThreshold());
    }

    @GetMapping
    @Operation(summary = "List thresholds")
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        if (thresholdService != null) {
            return ResponseEntity.ok(thresholdService.getAllThresholds());
        }
        return ResponseEntity.ok(List.of());
    }
}