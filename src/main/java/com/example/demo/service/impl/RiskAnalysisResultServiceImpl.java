package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.service.RiskThresholdService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repository;
    private final RiskThresholdService thresholdService;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository repository,
            RiskThresholdService thresholdService) {

        this.repository = repository;
        this.thresholdService = thresholdService;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        RiskThreshold threshold = thresholdService.getActiveThreshold();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setIsHighRisk(false);

        return repository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
