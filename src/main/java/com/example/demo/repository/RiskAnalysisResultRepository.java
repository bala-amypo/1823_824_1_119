package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RiskAnalysisResult;

public interface RiskAnalysisResultRepository
        extends JpaRepository<RiskAnalysisResult, Long> {

    // ✅ Matches entity field: Long portfolioId
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}
