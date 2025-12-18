package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioServiceImpl(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {

        repository.findByUserIdAndPortfolioName(
                portfolio.getUserId(),
                portfolio.getPortfolioName()
        ).ifPresent(p -> {
            throw new RuntimeException("Duplicate portfolio name for user");
        });

        return repository.save(portfolio);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {

        UserPortfolio existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        existing.setPortfolioName(portfolio.getPortfolioName());
        return repository.save(existing);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deactivatePortfolio(Long id) {
        UserPortfolio portfolio = getPortfolioById(id);
        portfolio.setActive(false);
        repository.save(portfolio);
    }
}
