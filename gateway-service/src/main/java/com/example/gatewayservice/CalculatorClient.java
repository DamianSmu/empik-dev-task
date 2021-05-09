package com.example.gatewayservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@FeignClient("calculator")
public interface CalculatorClient {
    @PostMapping("/add")
    int addNumbers(@RequestBody Map<String, Object> payload);
}
