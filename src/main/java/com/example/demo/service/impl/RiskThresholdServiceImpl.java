package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = getThresholdById(id);
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
