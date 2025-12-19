package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserPortfolio portfolio;

    private LocalDateTime analysisDate;

    private Double highestStockPercentage;

    private Double highestSectorPercentage;

    private Boolean isHighRisk;

    public RiskAnalysisResult() {
    }

    public RiskAnalysisResult(
            UserPortfolio portfolio,
            Double highestStockPercentage,
            Double highestSectorPercentage,
            Boolean isHighRisk) {

        this.portfolio = portfolio;
        this.analysisDate = LocalDateTime.now();
        this.highestStockPercentage = highestStockPercentage;
        this.highestSectorPercentage = highestSectorPercentage;
        this.isHighRisk = isHighRisk;
    }
}
