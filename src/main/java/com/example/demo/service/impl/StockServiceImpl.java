package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Stock createStock(Stock stock) {

        repository.findByTicker(stock.getTicker())
                .ifPresent(s -> {
                    throw new RuntimeException("Duplicate ticker");
                });

        return repository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {

        Stock existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        existing.setTicker(stock.getTicker());
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());

        return repository.save(existing);
    }

    @Override
    public Stock getStockById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock stock = getStockById(id);
        stock.setActive(false);
        repository.save(stock);
    }
}
