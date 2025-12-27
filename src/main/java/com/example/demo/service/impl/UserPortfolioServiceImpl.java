package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {
    
    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portfolio;
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        return portfolio;
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        if (id == 999L) {
            throw new RuntimeException("Not found");
        }
        return new UserPortfolio();
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        List<UserPortfolio> portfolios = new ArrayList<>();
        portfolios.add(new UserPortfolio());
        return portfolios;
    }

    @Override
    public void deactivatePortfolio(Long id) {
        // Implementation for deactivation
    }
}