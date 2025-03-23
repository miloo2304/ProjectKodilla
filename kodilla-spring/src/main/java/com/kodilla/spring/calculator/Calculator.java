package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Calculator {

    private final Display display;

    @Autowired
    public  Calculator(Display display) {  // Fixed constructor
        this.display = display;
    }

    public void calculate() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome!");
            System.out.println("Supported operators: +, -, *, /, ().");
            System.out.println("Type 'exit' to quit.");

            while (true) {
                System.out.println("\nEnter an equation or type 'exit' to quit:");
                if (!scanner.hasNextLine()) {
                    System.out.println("No input provided. Exiting.");
                    break;
                }
                String equation = scanner.nextLine();

                if (equation.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you! Goodbye!");
                    break;
                }

                try {
                    double result = evaluateEquation(equation);
                    display.displayValue(result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Try again.");
                }
            }
        }
    }

    public double evaluateEquation(String equation) {
        equation = equation.replaceAll("\\s+", "");
        if (!equation.matches("[0-9+\\-*/().]+")) {
            throw new IllegalArgumentException("Equation contains invalid characters!");
        }
        return evaluateWithParentheses(equation);
    }

    private double evaluateWithParentheses(String equation) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                stack.push(i);
            } else if (equation.charAt(i) == ')') {
                if (stack.isEmpty()) {  // Prevent popping from an empty stack
                    throw new IllegalArgumentException("Mismatched parentheses in equation.");
                }
                int start = stack.pop();
                String subExpression = equation.substring(start + 1, i);
                double subResult = evaluateSimpleExpression(subExpression);
                equation = equation.substring(0, start) + subResult + equation.substring(i + 1);
                i = start - 1;
            }
        }
        return evaluateSimpleExpression(equation);
    }

    private double evaluateSimpleExpression(String expression) {
        List<String> tokens = parseTokens(expression);
        List<String> intermediateTokens = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);
            if (token.equals("*") || token.equals("/")) {
                double left = Double.parseDouble(intermediateTokens.remove(intermediateTokens.size() - 1));
                double right = Double.parseDouble(tokens.get(i + 1));
                double result;
                if (token.equals("*")) {
                    result = left * right;
                } else {
                    if (right == 0) {
                        throw new IllegalArgumentException("Error: Division by zero.");
                    }
                    result = left / right;
                }
                intermediateTokens.add(String.valueOf(result));
                i += 2;
            } else {
                intermediateTokens.add(token);
                i++;
            }
        }
        double result = Double.parseDouble(intermediateTokens.get(0));
        for (int j = 1; j < intermediateTokens.size(); j += 2) {
            String operator = intermediateTokens.get(j);
            double nextNumber = Double.parseDouble(intermediateTokens.get(j + 1));
            if (operator.equals("+")) {
                result += nextNumber;
            } else if (operator.equals("-")) {
                result -= nextNumber;
            }
        }
        return result;
    }

    private List<String> parseTokens(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                currentToken.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')') {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
                if (ch == '-' && (i == 0 || expression.charAt(i - 1) == '(')) {
                    currentToken.append(ch);
                } else {
                    tokens.add(String.valueOf(ch));
                }
            } else {
                throw new IllegalArgumentException("Incorrect char in equation: " + ch);
            }
        }
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
        return tokens;
    }
}
