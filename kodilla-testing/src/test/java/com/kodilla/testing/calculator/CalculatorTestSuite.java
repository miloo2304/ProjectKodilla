package com.kodilla.testing.calculator;

import com.kodilla.exception.Project_6_2.Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestSuite {

    @Test
    void testSubstract() {

        Calculator calculator = new Calculator();

        int result = calculator.substract(10, 4);
        int result2 = calculator.substract(-10, -10);
        int result3 = calculator.substract(-10, 8);

        assertEquals(6, result, "The substraction result should be 6");
        assertEquals(0, result2, "The substraction result should be 0");
        assertEquals(-18, result3, "The substraction result should be -18");
    }

    @Test
    void testSum() {
        Calculator calculator = new Calculator();

        int result = calculator.sum(7, 3);
        int result2 = calculator.sum(-10, 2);
        int result3 = calculator.sum(-10, -8);

        assertEquals(10, result, "The sum result should be 10");
        assertEquals(-8, result2, "The sum result should be -8");
        assertEquals(-18, result3, "The sum result should be -2");

    }
}

