package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;
    private Double riskScore;
    private String riskLevel;

    public RiskAnalysisResult() {
    }

    public RiskAnalysisResult(Long portfolioId, Double riskScore, String riskLevel) {
        this.portfolioId = portfolioId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
    }

    public Long getId() {
        return id;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }
}
