package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock); // ✅
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        existing.setTicker(stock.getTicker());
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        existing.setActive(stock.getActive());

        return stockRepository.save(existing); // ✅
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        stock.setActive(false);
        stockRepository.save(stock); // ✅
    }
}
