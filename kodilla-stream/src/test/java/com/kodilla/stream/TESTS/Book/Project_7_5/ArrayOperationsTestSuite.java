package com.kodilla.stream.TESTS.Book.Project_7_5;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.kodilla.stream.Project_7_5.ArrayOperations;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {

        int[] numbers = {1, 2, 3, 4, 5};
        double average = ArrayOperations.getAverage(numbers);
        assertEquals(3.0, average, 0.1);
    }
}