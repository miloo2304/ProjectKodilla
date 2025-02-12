package com.kodilla.stream.Project_7_2.iterate;
import java.util.stream.*;

public final class NumbersGenerator {           // [3]

    public static void generateEven(int max) {   // [4]
        Stream.iterate(1, n -> n + 1)             // [5]
                .limit(max)                         // [6]
                .filter(n -> n % 2 == 0)            // [7]
                .forEach(System.out::println);      // [8]
    }
}
