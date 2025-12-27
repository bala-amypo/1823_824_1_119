package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    @Autowired
    private RiskThresholdRepository thresholdRepository;

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return thresholdRepository.save(threshold); // ✅
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));

        existing.setThresholdName(threshold.getThresholdName());
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.getActive());

        return thresholdRepository.save(existing); // ✅
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return thresholdRepository.findByActiveTrue();
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}
