package com.example.calculatorservice;

import java.util.Arrays;

public class NegativesNotAllowedException extends RuntimeException{
    public NegativesNotAllowedException(int[] negatives){
        super("Negatives numbers not allowed: " + Arrays.toString(negatives));
    }
}
