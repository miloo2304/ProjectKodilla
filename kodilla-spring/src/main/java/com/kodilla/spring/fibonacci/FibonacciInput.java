package com.kodilla.spring.fibonacci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class FibonacciInput {

    private final Fibonacci fibonacci;
    private int result = 0;

    @Autowired
    public FibonacciInput(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    public Integer getFibonacci() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Welcome!");
        System.out.println("Type a non-negative integer to calculate the Fibonacci number or type 'exit' to quit.");

        try {
            while (true) {
                System.out.print("Enter a non-negative integer (or 'exit' to quit): ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you! Goodbye!");
                    return result;
                }
                try {
                    int n = Integer.parseInt(input);
                    if (n < 0) {
                        System.out.println("Error: The input must be a non-negative integer.");
                        continue;
                    }
                    result = fibonacci.fibonacci(n);
                    return result;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid non-negative integer or type 'exit' to quit.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
        return result;
    }
}