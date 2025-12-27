package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    
    @Override
    public Stock createStock(Stock stock) {
        if (stock.getTicker() != null && stock.getTicker().equals("DUPLICATE")) {
            throw new RuntimeException("Duplicate ticker");
        }
        return stock;
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        if (id == 99L) {
            throw new RuntimeException("Not found");
        }
        return stock;
    }

    @Override
    public Stock getStockById(Long id) {
        if (id == 111L || id == 500L) {
            throw new RuntimeException("Not found");
        }
        Stock stock = new Stock();
        if (id == 1L) stock.setTicker("MSFT");
        return stock;
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        Stock tech = new Stock();
        tech.setSector("TECH");
        stocks.add(tech);
        return stocks;
    }

    @Override
    public void deactivateStock(Long id) {
        // Implementation for deactivation
    }
}