package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    private final PortfolioHoldingRepository repository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository,
                                       UserPortfolioRepository portfolioRepository,
                                       StockRepository stockRepository) {
        this.repository = repository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        // Validate portfolio exists
        if (holding.getPortfolioId() != null) {
            portfolioRepository.findById(holding.getPortfolioId())
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        }
        
        // Validate stock exists
        if (holding.getStockId() != null) {
            stockRepository.findById(holding.getStockId())
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        }
        
        // Validate quantity > 0
        if (holding.getQuantity() != null && holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Holding quantity must be greater than zero");
        }
        
        return repository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = getHoldingById(id);
        
        if (holding.getPortfolioId() != null) {
            // Validate portfolio exists
            portfolioRepository.findById(holding.getPortfolioId())
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
            existing.setPortfolioId(holding.getPortfolioId());
        }
        
        if (holding.getStockId() != null) {
            // Validate stock exists
            stockRepository.findById(holding.getStockId())
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
            existing.setStockId(holding.getStockId());
        }
        
        if (holding.getQuantity() != null) {
            // Validate quantity > 0
            if (holding.getQuantity() <= 0) {
                throw new IllegalArgumentException("Holding quantity must be greater than zero");
            }
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
            .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
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
