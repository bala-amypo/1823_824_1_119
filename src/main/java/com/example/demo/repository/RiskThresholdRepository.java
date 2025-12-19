package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RiskThreshold;

public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {

    Optional<RiskThreshold> findByActiveTrue();
}
