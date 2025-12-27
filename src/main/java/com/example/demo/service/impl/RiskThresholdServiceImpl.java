package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {
    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return threshold;
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        return threshold;
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return new RiskThreshold();
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return new RiskThreshold();
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return List.of();
    }
}