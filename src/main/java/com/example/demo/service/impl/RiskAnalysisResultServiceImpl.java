package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repo;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult r =
                new RiskAnalysisResult(portfolioId, 0.5, "MEDIUM");
        return repo.save(r);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repo.findByPortfolioId(portfolioId);
    }
}
