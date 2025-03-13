package com.kodilla.good.patterns.challenges;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Factorial {
    public int n;
    public int factorial = 1;
    boolean validInput = false;
    Scanner scanner = new Scanner(System.in);

    public int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial isn't defined for negative number");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public void handleException() {
        while (!validInput) {
            System.out.print("Please type an integer number: ");
            try {
                n = scanner.nextInt();
                int result = calculateFactorial(n);
                System.out.println("Factorial from " + n + " is: " + result);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("You typed incorrect type of data, required integer.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        factorial.handleException();
    }
}