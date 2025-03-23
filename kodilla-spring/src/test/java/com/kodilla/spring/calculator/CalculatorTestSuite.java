package com.kodilla.spring.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestSuite {

    @Mock
    private Display display;

    @InjectMocks
    private Calculator calculator;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateSimpleAddition() {
        // Given
        String equation = "2+3";
        // When
        double result = calculator.evaluateEquation(equation);
        // Then
        assertEquals(5.0, result, 0.001);
        verify(display, never()).displayValue(anyDouble());
    }

    @Test
    void testCalculateSimpleSubtraction() {
        // Given
        String equation = "10-7";
        // When
        double result = calculator.evaluateEquation(equation);
        // Then
        assertEquals(3.0, result, 0.001);
    }

    @Test
    void testCalculateWithParentheses() {
        // Given
        String equation = "(2+3)*4";
        // When
        double result = calculator.evaluateEquation(equation);
        // Then
        assertEquals(20.0, result, 0.001);
    }

    @Test
    void testDivisionByZero() {
        // Given
        String equation = "10/0";
        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluateEquation(equation);
        });
    }

    @Test
    void testInvalidCharacterInEquation() {
        // Given
        String equation = "2+3*a";
        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluateEquation(equation);
        });
        assertEquals("Equation contains invalid characters!", exception.getMessage());
    }

    @Test
    void testNestedParentheses() {
        // Given
        String equation = "((2+3)*4)/2";
        // When
        double result = calculator.evaluateEquation(equation);
        // Then
        assertEquals(10.0, result, 0.001);
    }

    @Test
    void testSimpleDisplayIntegration() {
        // Given
        String simulatedInput = "5*5\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Display display = mock(Display.class);  // Mock Display
        Calculator calculator = new Calculator(display); // Correctly instantiate the Calculator
        // When
        calculator.calculate();
        // Then
        verify(display).displayValue(25.0);
    }


    @Test
    void testNegativeNumberHandling() {
        // Given
        String equation = "-5+10";
        // When
        double result = calculator.evaluateEquation(equation);
        // Then
        assertEquals(5.0, result, 0.001);
    }
    @Test
    void testDivideAndMultiply() {
        //Given
        String equation = "5*(5/2)/2";
        // When
        double result = calculator.evaluateEquation(equation);
        // Then
        assertEquals(6.25, result, 0.001);
    }
}