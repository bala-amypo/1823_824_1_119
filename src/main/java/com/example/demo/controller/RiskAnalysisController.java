package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
@Tag(name = "Risk Analysis", description = "Risk analysis operations")
public class RiskAnalysisController {
    
    @Autowired(required = false)
    private RiskAnalysisService analysisService;
    
    @PostMapping("/analyze/{portfolioId}")
    @Operation(summary = "Run risk analysis")
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(@PathVariable Long portfolioId) {
        if (analysisService != null) {
            return ResponseEntity.ok(analysisService.analyzePortfolio(portfolioId));
        }
        return ResponseEntity.ok(new RiskAnalysisResult());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get analysis result")
    public ResponseEntity<RiskAnalysisResult> getAnalysis(@PathVariable Long id) {
        if (analysisService != null) {
            return ResponseEntity.ok(analysisService.getAnalysisById(id));
        }
        return ResponseEntity.ok(new RiskAnalysisResult());
    }

    @GetMapping("/portfolio/{portfolioId}")
    @Operation(summary = "List analyses for portfolio")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(@PathVariable Long portfolioId) {
        if (analysisService != null) {
            return ResponseEntity.ok(analysisService.getAnalysesForPortfolio(portfolioId));
        }
        return ResponseEntity.ok(List.of());
    }
}