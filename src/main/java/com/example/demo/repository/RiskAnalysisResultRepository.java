package com.example.demo.repository;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskAnalysisResultRepository
        extends JpaRepository<RiskAnalysisResult, Long> {

    // ✅ REQUIRED for service method
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}
