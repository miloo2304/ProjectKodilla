package com.kodilla.patterns.fibonacci;

public class Fibonacci {

    public int fibonacci(int n) {
        // Sprawdzenie, czy wartość 'n' jest poprawna
        if (n < 0) {
            throw new IllegalArgumentException("Input 'n' must be a non-negative integer.");
        }
        // Warunki bazowe
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Obliczanie wartości przy użyciu rekurencji
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

