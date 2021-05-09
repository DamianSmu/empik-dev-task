package com.example.calculatorservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

public class NegativesNotAllowedException extends ResponseStatusException {
    public NegativesNotAllowedException(int[] negatives) {
        super(HttpStatus.BAD_REQUEST, "Negatives numbers not allowed: " + Arrays.toString(negatives));
    }
}
