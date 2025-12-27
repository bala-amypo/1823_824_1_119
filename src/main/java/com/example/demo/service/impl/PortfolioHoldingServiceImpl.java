package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    @Autowired
    private PortfolioHoldingRepository holdingRepository;

    @Autowired
    private UserPortfolioRepository portfolioRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {

        // 🔴 FETCH FULL PORTFOLIO
        UserPortfolio portfolio = portfolioRepository.findById(
                holding.getPortfolio().getId()
        ).orElseThrow(() -> new RuntimeException("Portfolio not found"));

        // 🔴 FETCH FULL STOCK
        Stock stock = stockRepository.findById(
                holding.getStock().getId()
        ).orElseThrow(() -> new RuntimeException("Stock not found"));

        // ✅ SET FULL OBJECTS
        holding.setPortfolio(portfolio);
        holding.setStock(stock);

        return holdingRepository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {

        PortfolioHolding existing = holdingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());

        return holdingRepository.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolio_Id(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        holdingRepository.deleteById(id);
    }
}
