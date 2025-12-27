package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Autowired
    private UserPortfolioRepository portfolioRepository;

    @Autowired
    private PortfolioHoldingRepository holdingRepository;

    @Autowired
    private RiskThresholdRepository thresholdRepository;

    @Autowired
    private RiskAnalysisResultRepository analysisRepository;

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        // 1️⃣ Fetch portfolio
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        // 2️⃣ Fetch holdings
        List<PortfolioHolding> holdings =
                holdingRepository.findByPortfolio_Id(portfolioId);

        if (holdings.isEmpty()) {
            throw new RuntimeException("No holdings found for portfolio");
        }

        // 3️⃣ Fetch active threshold
        RiskThreshold threshold = thresholdRepository.findByActiveTrue();
        if (threshold == null) {
            throw new RuntimeException("No active risk threshold found");
        }

        // 4️⃣ Calculate total market value
        double totalValue = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().doubleValue())
                .sum();

        // 5️⃣ Calculate stock-wise and sector-wise exposure
        Map<Long, Double> stockExposure = new HashMap<>();
        Map<String, Double> sectorExposure = new HashMap<>();

        for (PortfolioHolding h : holdings) {
            Long stockId = h.getStock().getId();
            String sector = h.getStock().getSector();
            double value = h.getMarketValue().doubleValue();

            stockExposure.put(stockId,
                    stockExposure.getOrDefault(stockId, 0.0) + value);

            sectorExposure.put(sector,
                    sectorExposure.getOrDefault(sector, 0.0) + value);
        }

        // 6️⃣ Find highest percentages
        double highestStockPercent = stockExposure.values().stream()
                .mapToDouble(v -> (v / totalValue) * 100)
                .max()
                .orElse(0);

        double highestSectorPercent = sectorExposure.values().stream()
                .mapToDouble(v -> (v / totalValue) * 100)
                .max()
                .orElse(0);

        // 7️⃣ Risk decision
        boolean highRisk =
                highestStockPercent > threshold.getMaxSingleStockPercentage()
                        || highestSectorPercent > threshold.getMaxSectorPercentage();

        String notes = highRisk
                ? "Portfolio exceeds risk threshold"
                : "Portfolio within safe limits";

        // 8️⃣ Save analysis result
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setHighestStockPercentage(highestStockPercent);
        result.setHighestSectorPercentage(highestSectorPercent);
        result.setHighRisk(highRisk);
        result.setNotes(notes);

        return analysisRepository.save(result);
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
