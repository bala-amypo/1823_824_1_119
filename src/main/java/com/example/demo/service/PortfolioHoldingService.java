package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;

public interface PortfolioHoldingService {

    PortfolioHolding addHolding(PortfolioHolding holding);

    PortfolioHolding getHoldingById(Long id);
}
