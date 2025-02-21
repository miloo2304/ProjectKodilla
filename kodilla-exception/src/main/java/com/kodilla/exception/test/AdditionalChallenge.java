package com.kodilla.exception.test;
import java.util.Scanner;

public class AdditionalChallenge {

    public static double power(double base, double exponent) {
        if (base == 0 && exponent == 0) {
            return 1;
        }
        if (base == 0) {
            if (exponent < 0) {
                throw new ArithmeticException("Error: Cannot raise 0 to a negative power.");
            }
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            return 1.0 / power(base, -exponent);
        }
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter base: ");
            double base = scanner.nextDouble();


            if (base < -1e9 || base > 1e9) {
                System.out.println("Error: Base value is out of acceptable range. Max is 1*e^9");
                return;
            }

            System.out.print("Enter exponent: ");
            double exponent = scanner.nextDouble();

            if (exponent < -1e6 || exponent > 1e6) {
                System.out.println("Error: Exponent value is out of acceptable range. Max is 1*e^9");
                return;
            }

            double result = power(base, exponent);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Please enter valid numbers.");
        } finally {
            System.out.println("Execution finished.");
            scanner.close();
        }
    }
}
