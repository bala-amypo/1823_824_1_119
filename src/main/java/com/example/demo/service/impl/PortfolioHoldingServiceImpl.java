package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding addHolding(PortfolioHolding holding) {

      
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        
        if (holding.getMarketValue() == null ||
                holding.getMarketValue().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Market value must be >= 0");
        }

        Stock stock = holding.getStock();
        if (stock == null || !Boolean.TRUE.equals(stock.getActive())) {
            throw new RuntimeException("Only active stocks can be added to portfolio");
        }

        return repository.save(holding);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));
    }
}
