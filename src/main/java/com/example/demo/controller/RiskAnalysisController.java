package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService riskAnalysisService;

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> analyze(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(riskAnalysisService.analyzePortfolio(portfolioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getById(@PathVariable Long id) {
        return ResponseEntity.ok(riskAnalysisService.getAnalysisById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getByPortfolio(
            @PathVariable Long portfolioId) {
        return ResponseEntity.ok(riskAnalysisService.getAnalysesForPortfolio(portfolioId));
    }
}
