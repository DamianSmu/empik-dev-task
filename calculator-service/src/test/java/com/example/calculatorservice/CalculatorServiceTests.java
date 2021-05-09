package com.example.calculatorservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class CalculatorServiceTests {

    @Test
    void whenDelimitersWereNotChangedShouldUseDefaultDelimiters() {
        CalculatorService calc = new CalculatorService();
        String testString = "1\n1,1\n1";
        int result = calc.add(testString);
        Assertions.assertEquals(4, result);
        Assertions.assertEquals(calc.getDelimiters(), calc.DEFAULT_DELIMITERS_REGEX);
    }

    @Test
    void whenThereAreNegativesShouldThrowNegativesNotAllowedException() {
        CalculatorService calc = new CalculatorService();
        String testString = "1\n1,-1\n-2";
        String expectedMessage = "Negatives numbers not allowed: [-1, -2]";
        Assertions.assertThrows(NegativesNotAllowedException.class, () -> calc.add(testString), expectedMessage);
    }

    @Test
    void shouldIgnoreBiggerThan1000() {
        CalculatorService calc = new CalculatorService();
        String testString = "1000\n1,999\n1001";
        int result = calc.add(testString);
        Assertions.assertEquals(2000, result);
    }

    @Test
    void shouldSupportDifferentDelimiters() {
        CalculatorService calc = new CalculatorService();
        String specialChars = "!\"#$%&'()*+./:;>=<?@\\^_`{|}~,"; //without "-[]"
        for (char ch : specialChars.toCharArray()) {
            String testString = "//" + ch + "\n1" + ch + "1\n1" + ch + "1";
            int result = calc.add(testString);
            Assertions.assertEquals(4, result);
        }
    }

    @Test
    void shouldSupportDifferentDelimitersOfDifferentSize() {
        CalculatorService calc = new CalculatorService();
        String testString = "//[!][@@][###]\n1!1@@1###1\n1";
        int result = calc.add(testString);
        Assertions.assertEquals(5, result);
    }
}
