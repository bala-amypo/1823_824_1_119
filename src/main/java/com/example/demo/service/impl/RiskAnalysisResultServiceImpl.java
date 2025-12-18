package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisResultService;
import com.example.demo.service.RiskThresholdService;

import org.springframework.stereotype.Service;

@Service
public class RiskAnalysisResultServiceImpl implements RiskAnalysisResultService {

    private final RiskAnalysisResultRepository repository;
    private final RiskThresholdService thresholdService;

    public RiskAnalysisResultServiceImpl(
            RiskAnalysisResultRepository repository,
            RiskThresholdService thresholdService) {

        this.repository = repository;
        this.thresholdService = thresholdService;
    }

    @Override
    public RiskAnalysisResult saveResult(RiskAnalysisResult result) {

        RiskThreshold threshold = thresholdService.getActiveThreshold();

        boolean highRisk =
                result.getHighestStockPercentage() > threshold.getMaxSingleStockPercentage()
             || result.getHighestSectorPercentage() > threshold.getMaxSectorPercentage();

        result.setIsHighRisk(highRisk);

        return repository.save(result);
    }

    @Override
    public RiskAnalysisResult getResultById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk analysis result not found"));
    }
}
