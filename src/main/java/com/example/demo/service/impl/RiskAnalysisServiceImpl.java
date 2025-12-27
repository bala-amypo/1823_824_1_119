package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setHighestStockPercentage(50.0);
        result.setHighRisk(false);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        return result;
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setId(id);
        result.setHighestStockPercentage(40.0);
        result.setHighRisk(false);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        return result;
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return Collections.emptyList();
    }
}
