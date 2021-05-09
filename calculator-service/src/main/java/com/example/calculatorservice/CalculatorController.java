package com.example.calculatorservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Integer> addNumbers(@RequestBody Map<String, Object> payload) {
        int result = calculatorService.add(payload.get("numbers").toString());
        return ResponseEntity.ok().body(result);
    }
}
