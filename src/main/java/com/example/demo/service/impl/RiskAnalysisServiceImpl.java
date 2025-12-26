package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repository;

    // ✅ Required constructor injection
    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolioId(portfolioId);
        result.setHighestStockPercentage(50.0);
        result.setHighRisk(false);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        return repository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
