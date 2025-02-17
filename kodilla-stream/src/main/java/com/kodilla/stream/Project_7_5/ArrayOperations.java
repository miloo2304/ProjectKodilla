package com.kodilla.stream.Project_7_5;
import java.util.stream.IntStream;

public interface ArrayOperations {
    public static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(i -> System.out.println(numbers[i]));

        return IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average()
                .orElse(0.0);
    }
}
