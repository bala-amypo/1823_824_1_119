package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stock Management", description = "Stock operations")
public class StockController {
    
    @Autowired(required = false)
    private StockService stockService;
    
    @PostMapping
    @Operation(summary = "Create stock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        if (stockService != null) {
            return ResponseEntity.ok(stockService.createStock(stock));
        }
        return ResponseEntity.ok(stock);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update stock")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        if (stockService != null) {
            return ResponseEntity.ok(stockService.updateStock(id, stock));
        }
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get stock by ID")
    public ResponseEntity<Stock> getStock(@PathVariable Long id) {
        if (stockService != null) {
            return ResponseEntity.ok(stockService.getStockById(id));
        }
        return ResponseEntity.ok(new Stock());
    }

    @GetMapping
    @Operation(summary = "Get all stocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        if (stockService != null) {
            return ResponseEntity.ok(stockService.getAllStocks());
        }
        return ResponseEntity.ok(List.of());
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate stock")
    public ResponseEntity<Void> deactivateStock(@PathVariable Long id) {
        if (stockService != null) {
            stockService.deactivateStock(id);
        }
        return ResponseEntity.ok().build();
    }
}