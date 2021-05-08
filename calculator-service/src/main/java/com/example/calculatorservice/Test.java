package com.example.calculatorservice;

public class Test {
    public static void main(String[] args) {
        //String string = "//[***][:]\n1005***1:1\n1";
        String string = "//:\n1:1:1:1";
        System.out.println(new CalculatorService().extractDelimiters(string).toString());
        System.out.println(new CalculatorService().add(string));
    }
}
