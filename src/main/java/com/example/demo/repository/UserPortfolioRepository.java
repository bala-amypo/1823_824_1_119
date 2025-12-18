package com.example.demo.repository;

import com.example.demo.model.UserPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Long> {

    List<UserPortfolio> findByUserId(Long userId);

    Optional<UserPortfolio> findByUserIdAndPortfolioName(Long userId, String portfolioName);
}
