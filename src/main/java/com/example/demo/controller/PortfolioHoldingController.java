package com.example.demo.controller;

import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    public PortfolioHoldingController(PortfolioHoldingService service) {
    }
}
