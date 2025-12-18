package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private LocalDateTime analysisDate;

    private Double highestStockPercentage;
    private Double highestSectorPercentage;

    private Boolean isHighRisk;
    private String notes;

    @PrePersist
    public void onCreate() {
        this.analysisDate = LocalDateTime.now();
    }

    public RiskAnalysisResult() {
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public LocalDateTime getAnalysisDate() {
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

    public Boolean getIsHighRisk() {
        return isHighRisk;
    }

    public void setIsHighRisk(Boolean isHighRisk) {
        this.isHighRisk = isHighRisk;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
