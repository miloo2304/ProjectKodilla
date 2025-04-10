package com.kodilla.hibernate.additionally;

import java.util.Arrays;

public class Table {

    public int[] numbers = {3, 1, 1, 5, 6, 7, 9, 15, 3, 4, 7, 10};

    public void findSecondMinAndMax() {
        try {
            if (numbers.length < 2) {
                throw new IndexOutOfBoundsException("Table includes less than two numbers: " + numbers.length);
            }
            int secondMin = Arrays.stream(numbers)
                    .sorted()
                    .skip(1)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Second minimum not found"));
            System.out.println("Second minimum: " + secondMin);

            int secondMax = Arrays.stream(numbers)
                    .map(i -> -i)
                    .sorted()
                    .skip(1)
                    .map(i -> -i)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Second maximum not found"));
            System.out.println("Second maximum: " + secondMax);

        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Table table = new Table();
        table.findSecondMinAndMax();
    }
}