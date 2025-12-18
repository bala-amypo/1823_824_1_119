package com.example.demo.repository;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskAnalysisResultRepository
        extends JpaRepository<RiskAnalysisResult, Long> {
}
