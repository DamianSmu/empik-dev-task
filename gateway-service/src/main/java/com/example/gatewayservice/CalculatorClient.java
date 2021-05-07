package com.example.gatewayservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("calculator")
public interface CalculatorClient {
    @GetMapping("/add/{numbers}")
    String addNumbers(@PathVariable("numbers") String numbers);
}
