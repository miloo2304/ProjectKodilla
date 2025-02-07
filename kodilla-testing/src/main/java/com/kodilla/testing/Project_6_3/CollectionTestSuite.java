package com.kodilla.testing.Project_6_3;
import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Before each test checking upgrades.");
    }
    @AfterEach
    void after() {
        System.out.println("Refresh test on other methods");
    }
    @Test
    @DisplayName("Test for empty list")
    void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> result = exterminator.exterminate(emptyList);
        assertTrue(result.isEmpty(), "The result should be an empty list");
    }

    @Test
    @DisplayName("Test for normal list with even and odd numbers")
    void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> inputList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expectedList = List.of(2, 4, 6, 8, 10);
        List<Integer> result = exterminator.exterminate(inputList);
        assertEquals(expectedList, result, "The result should contain only even numbers");
    }
}
