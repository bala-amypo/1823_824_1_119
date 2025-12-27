package com.example.demo.repository;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RiskAnalysisResultRepository {
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}