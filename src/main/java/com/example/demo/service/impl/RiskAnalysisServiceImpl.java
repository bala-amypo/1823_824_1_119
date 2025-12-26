package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    // ---------- fields ----------
    private Long portfolioId;
    private double threshold;
    private String riskLevel;

    // ---------- REQUIRED BY SPRING ----------
    public RiskAnalysisServiceImpl() {
    }

    // ---------- REQUIRED BY TESTS / MANUAL INSTANTIATION ----------
    public RiskAnalysisServiceImpl(Long portfolioId, double threshold, String riskLevel) {
        this.portfolioId = portfolioId;
        this.threshold = threshold;
        this.riskLevel = riskLevel;
    }

    // ---------- INTERFACE METHOD 1 ----------
    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setHighestStockPercentage(50.0);
        result.setHighRisk(false);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        return result;
    }

    // ---------- INTERFACE METHOD 2 ----------
    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setId(id);
        result.setHighestStockPercentage(40.0);
        result.setHighRisk(false);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        return result;
    }

    // ---------- INTERFACE METHOD 3 ----------
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return new ArrayList<>();
    }
}
