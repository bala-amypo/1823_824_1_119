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

    // ✅ Constructor injection (required by Spring)
    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    // ---------- INTERFACE METHOD 1 ----------
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setHighestStockPercentage(50.0);
        result.setHighRisk(false);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        return repository.save(result);
    }

    // ---------- INTERFACE METHOD 2 ----------
    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk analysis not found"));
    }

    // ---------- INTERFACE METHOD 3 ----------
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repository.findByPortfolio_Id(portfolioId);
    }
}
