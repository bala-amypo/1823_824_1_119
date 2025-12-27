package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PortfolioHolding {
    private Long id;
    private UserPortfolio portfolio;
    private Stock stock;
    private Double quantity;
    private BigDecimal marketValue;
    private Timestamp lastUpdated;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }
    
    public Stock getStock() { return stock; }
    public void setStock(Stock stock) { this.stock = stock; }
    
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    
    public BigDecimal getMarketValue() { return marketValue; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }
    
    public Timestamp getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Timestamp lastUpdated) { this.lastUpdated = lastUpdated; }
}