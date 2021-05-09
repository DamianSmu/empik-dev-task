package com.example.calculatorservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidNumbersFormatException extends ResponseStatusException {
    public InvalidNumbersFormatException() {
        super(HttpStatus.BAD_REQUEST, "Invalid string format");
    }
}