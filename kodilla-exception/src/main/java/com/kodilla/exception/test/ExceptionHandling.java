package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handleException(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyIWillThrowException(x, y);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Execution completed, whether exception was thrown or not.");
        }
    }
}
