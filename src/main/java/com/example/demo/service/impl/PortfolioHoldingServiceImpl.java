package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        return repository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = getHoldingById(id);

        if (holding.getPortfolioId() != null) {
            existing.setPortfolioId(holding.getPortfolioId());
        }
        if (holding.getStockId() != null) {
            existing.setStockId(holding.getStockId());
        }
        if (holding.getQuantity() != null) {
            existing.setQuantity(holding.getQuantity());
        }
        if (holding.getActive() != null) {
            existing.setActive(holding.getActive());
        }

        return repository.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Holding not found"));
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
