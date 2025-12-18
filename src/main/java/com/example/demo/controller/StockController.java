package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Create Stock
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock created = stockService.createStock(stock);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Update Stock
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(
            @PathVariable Long id,
            @RequestBody Stock stock) {

        Stock updated = stockService.updateStock(id, stock);
        return ResponseEntity.ok(updated);
    }

    // Get Stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    // Get All Stocks
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    // Deactivate Stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateStock(@PathVariable Long id) {
        stockService.deactivateStock(id);
        return ResponseEntity.noContent().build();
    }
}