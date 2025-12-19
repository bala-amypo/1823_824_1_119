package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ticker;

    private String companyName;
    private String sector;
    private Boolean active = true;

    public Stock() {
    }

    public Stock(String ticker, String companyName, String sector, Boolean active) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.sector = sector;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
