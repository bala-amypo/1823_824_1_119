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

        // 🔴 Ensure only ONE active threshold
        if (Boolean.TRUE.equals(threshold.getActive())) {
            List<RiskThreshold> all = thresholdRepository.findAll();
            for (RiskThreshold t : all) {
                t.setActive(false);
            }
            thresholdRepository.saveAll(all);
        }

        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {

        RiskThreshold existing = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));

        existing.setThresholdName(threshold.getThresholdName());
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());

        // 🔴 Ensure only ONE active threshold
        if (Boolean.TRUE.equals(threshold.getActive())) {
            List<RiskThreshold> all = thresholdRepository.findAll();
            for (RiskThreshold t : all) {
                t.setActive(false);
            }
            thresholdRepository.saveAll(all);
            existing.setActive(true);
        }

        return thresholdRepository.save(existing);
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return thresholdRepository.findFirstByActiveTrue()
                .orElseThrow(() -> new RuntimeException("No active threshold found"));
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
