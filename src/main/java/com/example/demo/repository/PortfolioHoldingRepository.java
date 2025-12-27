package com.example.demo.repository;

import com.example.demo.model.PortfolioHolding;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PortfolioHoldingRepository {
    List<PortfolioHolding> findByPortfolioId(Long portfolioId);
}