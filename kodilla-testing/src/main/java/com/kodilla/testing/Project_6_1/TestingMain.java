package com.kodilla.testing.Project_6_1;

import com.kodilla.testing.Project_6_3.OddNumbersExterminator;
import java.util.*;
public class TestingMain {
    public static void main(String[] args) {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(exterminator.getNumbers());
        System.out.println("Even numbers: " + result);
    }
}
