package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisResultController {

    private final RiskAnalysisResultService service;

    public RiskAnalysisResultController(RiskAnalysisResultService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskAnalysisResult> createResult(
            @RequestBody RiskAnalysisResult result) {

        return new ResponseEntity<>(
                service.saveResult(result),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getResult(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getResultById(id));
    }
}
