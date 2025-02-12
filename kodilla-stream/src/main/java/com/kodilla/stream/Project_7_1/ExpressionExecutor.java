package com.kodilla.stream.Project_7_1;
import com.kodilla.stream.Project_7_1.MathExpresion;

public class ExpressionExecutor {
    public void executeExpression(double a, double b, MathExpresion mathExpression) {
        double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result equals: " + result);
    }
}
