package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Autowired
    private RiskAnalysisResultRepository analysisRepository;

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        return analysisRepository.save(result); // ✅
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return analysisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolio_Id(portfolioId);
    }
}
