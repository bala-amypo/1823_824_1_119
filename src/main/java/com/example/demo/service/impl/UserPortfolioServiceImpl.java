package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    @Autowired
    private UserPortfolioRepository portfolioRepository;

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portfolioRepository.save(portfolio); // ✅
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        existing.setPortfolioName(portfolio.getPortfolioName());
        existing.setActive(portfolio.getActive());

        return portfolioRepository.save(existing); // ✅ triggers @PreUpdate
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }

    @Override
    public void deactivatePortfolio(Long id) {
        UserPortfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        portfolio.setActive(false);
        portfolioRepository.save(portfolio); // ✅
    }
}
