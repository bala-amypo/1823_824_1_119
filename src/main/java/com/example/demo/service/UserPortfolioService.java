package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserPortfolio;

public interface UserPortfolioService {

    UserPortfolio createPortfolio(UserPortfolio portfolio);

    UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio);

    UserPortfolio getPortfolioById(Long id);

    List<UserPortfolio> getPortfoliosByUser(Long userId);

    void deactivatePortfolio(Long id);
}
