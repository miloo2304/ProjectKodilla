package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass implements CommandLineRunner {

    @Autowired
    private Calculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

    @Override
    public void run(String... args) {
        calculator.calculate();
    }
}

