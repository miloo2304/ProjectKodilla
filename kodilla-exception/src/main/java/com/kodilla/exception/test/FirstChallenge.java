package com.kodilla.exception.test;

import java.util.Scanner;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0;

        try {
            System.out.print("Enter the value for a: ");
            double a = scanner.nextDouble();
            System.out.print("Enter the value for b: ");
            double b = scanner.nextDouble();

            if (a < -1e9 || a > 1e9 || b < -1e9 || b > 1e9) {
                System.out.println("Error: One or both values are out of the acceptable range (-1*e^9 to 1*e^9).");
                return;
            }
            if (a == 0) {
                result = 0;
                System.out.println("a is 0, result is set to 0.");
            } else {
                result = firstChallenge.divide(a, b);
            }

        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
            result = 0;
        } catch (Exception e) {
            System.out.println("Error: Please enter valid numbers.");
        } finally {
            System.out.println("Count finished.");
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
