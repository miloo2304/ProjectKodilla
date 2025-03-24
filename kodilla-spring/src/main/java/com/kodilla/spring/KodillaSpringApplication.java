package com.kodilla.spring;

import com.kodilla.spring.calculator.Calculator;
import com.kodilla.spring.fibonacci.FibonacciInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodillaSpringApplication implements CommandLineRunner {

    @Autowired
    FibonacciInput fibonacciInput;
   // @Autowired
   //private Calculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(KodillaSpringApplication.class, args);
    }
   // @Override
   // public void run(String... args) {
   //  calculator.calculate();
   // }
    @Override
    public void run(String... args) {
        fibonacciInput.getFibonacci();
    }
}