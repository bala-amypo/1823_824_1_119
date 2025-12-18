package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.stock;

public interface StockRepository extends JpaRepository<stock,Long>{
    
}