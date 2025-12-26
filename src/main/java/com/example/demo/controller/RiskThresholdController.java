package com.example.demo.controller;

import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thresholds")
public class RiskThresholdController {

    public RiskThresholdController(RiskThresholdService service) {
    }
}
