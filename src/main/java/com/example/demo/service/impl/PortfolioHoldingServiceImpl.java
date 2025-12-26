package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.UserPortfolio;
import com.example.demo.model.Stock;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository repository,
            UserPortfolioRepository portfolioRepository,
            StockRepository stockRepository) {

        this.repository = repository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {

        // Validate portfolio
        if (holding.getPortfolio() != null) {
            UserPortfolio portfolio = portfolioRepository.findById(
                    holding.getPortfolio().getId()
            ).orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
            holding.setPortfolio(portfolio);
        }

        // Validate stock
        if (holding.getStock() != null) {
            Stock stock = stockRepository.findById(
                    holding.getStock().getId()
            ).orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
            holding.setStock(stock);
        }

        // Validate quantity
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Holding quantity must be greater than zero");
        }

        return repository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {

        PortfolioHolding existing = getHoldingById(id);

        if (holding.getPortfolio() != null) {
            UserPortfolio portfolio = portfolioRepository.findById(
                    holding.getPortfolio().getId()
            ).orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
            existing.setPortfolio(portfolio);
        }

        if (holding.getStock() != null) {
            Stock stock = stockRepository.findById(
                    holding.getStock().getId()
            ).orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
            existing.setStock(stock);
        }

        if (holding.getQuantity() != null) {
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
        return repository.findByPortfolio_Id(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        repository.deleteById(id);
    }
}
