package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    @Autowired
    private PortfolioHoldingRepository holdingRepository;

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        return holdingRepository.save(holding); // ✅
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = holdingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding not found"));

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());

        return holdingRepository.save(existing); // ✅
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
