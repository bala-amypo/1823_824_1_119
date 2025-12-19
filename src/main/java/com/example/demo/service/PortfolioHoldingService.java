package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PortfolioHolding;

public interface PortfolioHoldingService {

    PortfolioHolding createHolding(PortfolioHolding holding);

    PortfolioHolding updateHolding(Long id, PortfolioHolding holding);

    PortfolioHolding getHoldingById(Long id);

    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);

    void deleteHolding(Long id);
}
