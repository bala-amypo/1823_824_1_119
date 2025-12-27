package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        return new RiskAnalysisResult();
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return new RiskAnalysisResult();
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return List.of();
    }
}