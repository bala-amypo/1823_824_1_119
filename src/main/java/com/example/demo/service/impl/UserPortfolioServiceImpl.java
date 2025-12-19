package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository userPortfolioRepository;

    public UserPortfolioServiceImpl(UserPortfolioRepository userPortfolioRepository) {
        this.userPortfolioRepository = userPortfolioRepository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return userPortfolioRepository.save(portfolio);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = getPortfolioById(id);
        return userPortfolioRepository.save(existing);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return userPortfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return userPortfolioRepository.findByUserId(userId);
    }

    @Override
    public void deactivatePortfolio(Long id) {
        UserPortfolio portfolio = getPortfolioById(id);
        portfolio.setActive(false);
        userPortfolioRepository.save(portfolio);
    }
}
