package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@RestController
@RequestMapping("/api/risk-analysis")
@Tag(name = "Risk Analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService riskAnalysisService;

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @PostMapping("/analyze/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(
            @PathVariable Long portfolioId) {

        return ResponseEntity.ok(
                riskAnalysisService.analyzePortfolio(portfolioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getAnalysisById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                riskAnalysisService.getAnalysisById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(
            @PathVariable Long portfolioId) {

        return ResponseEntity.ok(
                riskAnalysisService.getAnalysesForPortfolio(portfolioId));
    }
}
