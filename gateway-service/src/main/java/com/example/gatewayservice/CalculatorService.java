package com.example.gatewayservice;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class CalculatorService {
    private final CalculatorClient calculatorClient;

    public CalculatorService(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    public int addNumbers(@RequestBody Map<String, Object> payload) {
        return calculatorClient.addNumbers(payload);
    }
}
