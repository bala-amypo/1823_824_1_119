package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double highestStockPercentage;

    private Boolean highRisk;

    private Timestamp analysisDate;

    public RiskAnalysisResult() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Boolean getHighRisk() { return highRisk; }
    public void setHighRisk(Boolean highRisk) { this.highRisk = highRisk; }

    public boolean isHighRisk() {
        return Boolean.TRUE.equals(highRisk);
    }

    public Timestamp getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(Timestamp analysisDate) { this.analysisDate = analysisDate; }
}
