package com.example.demo.service;

import com.example.demo.model.RiskThreshold;

public interface RiskThresholdService {

    RiskThreshold createThreshold(RiskThreshold threshold);

    RiskThreshold getActiveThreshold();
}
