package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;

public interface RiskAnalysisResultService {

    RiskAnalysisResult saveResult(RiskAnalysisResult result);

    RiskAnalysisResult getResultById(Long id);
}
