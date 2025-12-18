package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {

        if (holding.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be > 0");
        }

        if (holding.getMarketValue().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Market value must be >= 0");
        }

        Stock stock = holding.getStock();
        if (!Boolean.TRUE.equals(stock.getActive())) {
            throw new RuntimeException("Only active stocks allowed");
        }

        return repository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {

        PortfolioHolding existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());

        return repository.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        repository.deleteById(id);
    }
}
