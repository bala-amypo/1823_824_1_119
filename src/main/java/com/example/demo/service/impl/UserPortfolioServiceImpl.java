package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserPortfolioService;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {
    private final UserPortfolioRepository repository;
    private final UserRepository userRepository;

    public UserPortfolioServiceImpl(UserPortfolioRepository repository,
                                    UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        // Validate user exists
        if (portfolio.getUserId() != null) {
            userRepository.findById(portfolio.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        }
        return repository.save(portfolio);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = getPortfolioById(id);
        
        if (portfolio.getPortfolioName() != null) {
            existing.setPortfolioName(portfolio.getPortfolioName());
        }
        
        if (portfolio.getUserId() != null) {
            // Validate user exists
            userRepository.findById(portfolio.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            existing.setUserId(portfolio.getUserId());
        }
        
        if (portfolio.getActive() != null) {
            existing.setActive(portfolio.getActive());
        }
        
        return repository.save(existing);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
    }

    @Override
    public List<UserPortfolio> getAllPortfolios() {
        return repository.findAll();
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