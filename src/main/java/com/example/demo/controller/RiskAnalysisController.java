package com.example.demo.controller;

import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
public class RiskAnalysisController {

    public RiskAnalysisController(RiskAnalysisService service) {
    }
}
