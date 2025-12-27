package com.example.demo.repository;

import com.example.demo.model.Stock;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository {
    Stock findByTicker(String ticker);
}