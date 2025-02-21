package com.kodilla.exception.Project_6_3;
import java.util.*;

public class OddNumbersExterminator {

        private List<Integer> numbers; // Class-level list

        public OddNumbersExterminator() {
            numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            numbers.add(4);
            numbers.add(5);
            numbers.add(6);
            numbers.add(7);
            numbers.add(8);
            numbers.add(9);
            numbers.add(10);
        }

        public List<Integer> exterminate(List<Integer> numbers) {
            List<Integer> evenNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
            return evenNumbers;
        }
        public List<Integer> getNumbers() { // Method to get numbers list
            return numbers;
        }
    }
