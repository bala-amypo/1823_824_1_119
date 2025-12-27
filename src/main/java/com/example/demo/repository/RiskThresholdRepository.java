package com.example.demo.repository;

import com.example.demo.model.RiskThreshold;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskThresholdRepository {
    RiskThreshold findByActiveTrue();
}