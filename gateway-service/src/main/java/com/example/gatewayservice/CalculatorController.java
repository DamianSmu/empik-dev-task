package com.example.gatewayservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value = "/add/{numbers}")
    public ResponseEntity<String> addNumbers(@PathVariable("numbers") String numbers) {
        String response = calculatorService.addNumbers(numbers);
        return ResponseEntity.ok().body(response);
    }
}
