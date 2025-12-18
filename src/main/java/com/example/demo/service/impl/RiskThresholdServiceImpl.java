package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100 ||
            threshold.getMaxSectorPercentage() < 0 ||
            threshold.getMaxSectorPercentage() > 100) {

            throw new RuntimeException("Percentages must be between 0 and 100");
        }

        return repository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {

        RiskThreshold existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));

        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.getActive());

        return repository.save(existing);
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("No active threshold"));
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return repository.findAll();
    }
}
