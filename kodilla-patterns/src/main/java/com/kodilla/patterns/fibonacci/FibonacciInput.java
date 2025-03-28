package com.kodilla.patterns.fibonacci;

import java.util.Scanner;

public class FibonacciInput {

    private final Fibonacci fibonacci;

    public FibonacciInput() {
        this.fibonacci = new Fibonacci(); // Tworzymy instancję klasy Fibonacci
    }

    public void getFibonacci() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome!");
        System.out.println("Type a non-negative integer to calculate the Fibonacci number or type 'exit' to quit.");

        try {
            while (true) {
                System.out.print("Enter a non-negative integer (or 'exit' to quit): ");
                input = scanner.nextLine();

                // Sprawdzamy, czy użytkownik chce zakończyć program
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you! Goodbye!");
                    break;
                }

                try {
                    int n = Integer.parseInt(input); // Parsowanie wartości wejściowej
                    if (n < 0) {
                        System.out.println("Error: The input must be a non-negative integer.");
                        continue;
                    }
                    int result = fibonacci.fibonacci(n); // Obliczanie wartości ciągu
                    System.out.println("Fibonacci number for n = " + n + " is: " + result);
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
    }
}

