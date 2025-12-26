package com.example.demo.service.impl;

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
        // no-args constructor
    }

    // ---------- REQUIRED BY TESTS / MANUAL INSTANTIATION ----------
    public RiskAnalysisServiceImpl(Long portfolioId, double threshold, String riskLevel) {
        this.portfolioId = portfolioId;
        this.threshold = threshold;
        this.riskLevel = riskLevel;
    }

    // ---------- INTERFACE METHOD ----------
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return new ArrayList<>();
    }
}
