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

    /**
     * POST /api/risk-analysis/analyze/{portfolioId}
     * Runs risk analysis for a portfolio
     */
    @PostMapping("/analyze/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> analyze(
            @PathVariable Long portfolioId) {

        return ResponseEntity.ok(
                riskAnalysisService.analyzePortfolio(portfolioId));
    }

    /**
     * GET /api/risk-analysis/portfolio/{portfolioId}
     * Returns all analysis results for a portfolio
     */
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getByPortfolio(
            @PathVariable Long portfolioId) {

        return ResponseEntity.ok(
                riskAnalysisService.getAnalysesForPortfolio(portfolioId));
    }
}
