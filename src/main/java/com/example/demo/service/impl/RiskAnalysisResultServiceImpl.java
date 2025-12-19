package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        throw new ResourceNotFoundException("Portfolio not found");
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
