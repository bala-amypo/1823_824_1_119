package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean highRisk;
    private String notes;

    @PrePersist
    public void onCreate() {
        analysisDate = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Timestamp getAnalysisDate() {
        return analysisDate;
    }

    public Double getHighestStockPercentage() {
        return highestStockPercentage;
    }

    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Double getHighestSectorPercentage() {
        return highestSectorPercentage;
    }

    public void setHighestSectorPercentage(Double highestSectorPercentage) {
        this.highestSectorPercentage = highestSectorPercentage;
    }

    public boolean isHighRisk() {
        return highRisk;
    }

    public void setHighRisk(boolean highRisk) {
        this.highRisk = highRisk;
    }

    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
