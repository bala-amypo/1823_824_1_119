package com.example.demo.model;

public class RiskThreshold {
    private Long id;
    private String thresholdName;
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private Boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getThresholdName() { return thresholdName; }
    public void setThresholdName(String thresholdName) { this.thresholdName = thresholdName; }
    
    public Double getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) { this.maxSingleStockPercentage = maxSingleStockPercentage; }
    
    public Double getMaxSectorPercentage() { return maxSectorPercentage; }
    public void setMaxSectorPercentage(Double maxSectorPercentage) { this.maxSectorPercentage = maxSectorPercentage; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}