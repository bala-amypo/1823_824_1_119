package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio_holdings")
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserPortfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    private Double quantity;

    private BigDecimal marketValue;

    private LocalDateTime lastUpdated;

    public PortfolioHolding() {
    }

    public PortfolioHolding(
            UserPortfolio portfolio,
            Stock stock,
            Double quantity,
            BigDecimal marketValue) {

        this.portfolio = portfolio;
        this.stock = stock;
        this.quantity = quantity;
        this.marketValue = marketValue;
        this.lastUpdated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }
}
