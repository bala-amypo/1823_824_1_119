package com.example.demo.model;

import java.sql.Timestamp;

public class RiskAnalysisResult {
    private Long id;
    private UserPortfolio portfolio;
    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean highRisk;
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }
    
    public Timestamp getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(Timestamp analysisDate) { this.analysisDate = analysisDate; }
    
    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(Double highestStockPercentage) { this.highestStockPercentage = highestStockPercentage; }
    
    public Double getHighestSectorPercentage() { return highestSectorPercentage; }
    public void setHighestSectorPercentage(Double highestSectorPercentage) { this.highestSectorPercentage = highestSectorPercentage; }
    
    public boolean isHighRisk() { return highRisk; }
    public void setHighRisk(boolean highRisk) { this.highRisk = highRisk; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}