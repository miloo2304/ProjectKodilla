package com.kodilla.stream;
import com.kodilla.stream.Project_7_1.SaySomething;
import com.kodilla.stream.Project_7_1.Executor;
import com.kodilla.stream.Project_7_1.Processor;
import com.kodilla.stream.Project_7_1.ExecuteSaySomething;
import com.kodilla.stream.Project_7_1.ExpressionExecutor;
import com.kodilla.stream.Project_7_1.Beautifier.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import com.kodilla.stream.Project_7_2.iterate.NumbersGenerator;


public class StreamMain {
    public static void main(String[] args) {
        //Project 7.2
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        /*
        //Project 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Good Morning", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Good Morning", text -> text.toUpperCase());
        poemBeautifier.beautify("Good Morning", text -> text.toLowerCase());
        poemBeautifier.beautify("Good Morning", text -> "♥" + text + "♥"); //I will ask about that when we will talk.
        poemBeautifier.beautify("Good Morning", text -> "\u2665" + text + "\u2665");
        poemBeautifier.beautify("Good Morning", text -> "★" + text + "★");
        poemBeautifier.beautify("Good Morning", text -> "*** " + text + " ***");
        poemBeautifier.beautify("Good Morning", text -> new StringBuilder(text).reverse().toString());
        poemBeautifier.beautify("Good Morning", text -> text.substring(0, text.length()).toLowerCase());
        */

        /*
        System.out.println("Hello, World!");
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


         */
    }
}