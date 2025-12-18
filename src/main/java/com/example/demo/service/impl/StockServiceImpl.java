package com.example.demo.service;
import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.service;
import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    private final StockRepositary stockRepository;
    public StockServiceImpl(StockRepository stockRepository){
        this.stockRepository = stockRepository ;
    }
    @Override
    public Stock updateStock(Long id, Stock stock){
        Stock existing = stockRepository.findById(id).orElseThrow(()-> new )
    }
}