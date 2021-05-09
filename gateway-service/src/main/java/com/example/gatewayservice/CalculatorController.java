package com.example.gatewayservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ResultsRepository repository;

    public CalculatorController(CalculatorService calculatorService, ResultsRepository repository) {
        this.calculatorService = calculatorService;
        this.repository = repository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ResultDto> addNumbers(@RequestBody Map<String, Object> payload) {
        int result = calculatorService.addNumbers(payload);
        Optional<Result> r = repository.findById(result);
        int occurrences = 0;
        if (r.isPresent()) {
            occurrences = r.get().getOccurrences() + 1;
            r.get().setOccurrences(occurrences);
            repository.save(r.get());
        } else {
            repository.save(new Result(result));
        }
        return ResponseEntity.ok().body(new ResultDto(result, occurrences));
    }
}
