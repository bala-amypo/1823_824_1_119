package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {
    private final RiskThresholdRepository repository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository,
                                    UserPortfolioRepository portfolioRepository) {
        this.repository = repository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        // Validate maxSingleStockPercentage range
        if (threshold.getMaxSingleStockPercentage() != null) {
            if (threshold.getMaxSingleStockPercentage() < 0 || 
                threshold.getMaxSingleStockPercentage() > 100) {
                throw new IllegalArgumentException(
                    "maxSingleStockPercentage must be between 0 and 100");
            }
        }
        
        // Validate maxSectorPercentage range
        if (threshold.getMaxSectorPercentage() != null) {
            if (threshold.getMaxSectorPercentage() < 0 || 
                threshold.getMaxSectorPercentage() > 100) {
                throw new IllegalArgumentException(
                    "maxSectorPercentage must be between 0 and 100");
            }
        }
        
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = getThresholdById(id);
        
        if (threshold.getThresholdName() != null) {
            existing.setThresholdName(threshold.getThresholdName());
        }
        
        if (threshold.getMaxSingleStockPercentage() != null) {
            // Validate range
            if (threshold.getMaxSingleStockPercentage() < 0 || 
                threshold.getMaxSingleStockPercentage() > 100) {
                throw new IllegalArgumentException(
                    "maxSingleStockPercentage must be between 0 and 100");
            }
            existing.setMaxSingleStockPercentage(
                threshold.getMaxSingleStockPercentage());
        }
        
        if (threshold.getMaxSectorPercentage() != null) {
            // Validate range
            if (threshold.getMaxSectorPercentage() < 0 || 
                threshold.getMaxSectorPercentage() > 100) {
                throw new IllegalArgumentException(
                    "maxSectorPercentage must be between 0 and 100");
            }
            existing.setMaxSectorPercentage(
                threshold.getMaxSectorPercentage());
        }
        
        if (threshold.getActive() != null) {
            existing.setActive(threshold.getActive());
        }
        
        return repository.save(existing);
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue()
            .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return repository.findAll();
    }
}