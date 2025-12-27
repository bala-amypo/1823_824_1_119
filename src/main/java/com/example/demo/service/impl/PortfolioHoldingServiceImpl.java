package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        return holding;
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        return holding;
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return new PortfolioHolding();
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return List.of();
    }

    @Override
    public void deleteHolding(Long id) {
    }
}