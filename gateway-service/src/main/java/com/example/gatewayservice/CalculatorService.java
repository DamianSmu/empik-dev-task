package com.example.gatewayservice;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final CalculatorClient calculatorClient;

    public CalculatorService(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }


    public String addNumbers(String numbers) {
        return calculatorClient.addNumbers(numbers);
    }
}
