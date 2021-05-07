package com.example.calculatorservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add/{numbers}")
    public ResponseEntity<String> addNumbers(@PathVariable("numbers") String numbers) {
        return ResponseEntity.ok().body(numbers);
    }
}
