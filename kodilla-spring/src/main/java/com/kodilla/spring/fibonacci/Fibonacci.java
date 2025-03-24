package com.kodilla.spring.fibonacci;
import org.springframework.stereotype.Component;

@Component
public class Fibonacci {

    public int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input 'n' must be a non-negative integer.");
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}