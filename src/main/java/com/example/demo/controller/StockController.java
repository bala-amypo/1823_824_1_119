package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<Stock> create(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.createStock(stock));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> get(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @GetMapping
    public ResponseEntity<List<Stock>> list() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        stockService.deactivateStock(id);
        return ResponseEntity.ok().build();
    }
}
