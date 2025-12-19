package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository riskAnalysisResultRepository;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository riskAnalysisResultRepository) {

        this.riskAnalysisResultRepository = riskAnalysisResultRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        throw new ResourceNotFoundException("Portfolio not found");
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return riskAnalysisResultRepository.findByPortfolioId(portfolioId);
    }
}
