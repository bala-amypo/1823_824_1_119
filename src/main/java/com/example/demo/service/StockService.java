package com.example.demo.service;
import java.util.List;
import com.example.demo.model.stock;

public interface StockService{
    Stock createStock(stock stock);
    Stock updateStock(Long id, stock stock);
    Stock getStockById(Long id);
    List<stock> getAllStocks();
    void deactivateStock(Long id);
    }