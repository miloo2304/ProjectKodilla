package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import com.kodilla.exception.test.ExceptionHandling;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTestSuite {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting tests...");
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(output));
        System.out.println("Starting test: " + testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.setOut(originalOut);
        System.out.println("Finished test: " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("All tests completed.");
    }

    private String captureConsoleOutput(Runnable runnable) {
        runnable.run();
        return output.toString();
    }

    @Test
    void testHandleException_noExceptionThrown() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = captureConsoleOutput(() -> exceptionHandling.handleException(1.5, 1.0));
        assertTrue(result.contains("Execution completed, whether exception was thrown or not."));
    }

    @Test
    void testHandleException_exceptionThrown_dueToX() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = captureConsoleOutput(() -> exceptionHandling.handleException(2.5, 0.9));
        assertTrue(result.contains("Exception caught: Exception thrown: Invalid input values"));
        assertTrue(result.contains("Execution completed, whether exception was thrown or not."));
    }

    @Test
    void testHandleException_exceptionThrown_dueToY() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = captureConsoleOutput(() -> exceptionHandling.handleException(1.0, 1.5));
        assertTrue(result.contains("Exception caught: Exception thrown: Invalid input values"));
        assertTrue(result.contains("Execution completed, whether exception was thrown or not."));
    }

    @Test
    void testHandleException_exceptionThrown_dueToBoth() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = captureConsoleOutput(() -> exceptionHandling.handleException(2.5, 1.5));
        assertTrue(result.contains("Exception caught: Exception thrown: Invalid input values"));
        assertTrue(result.contains("Execution completed, whether exception was thrown or not."));
    }

    @Test
    void testHandleException_validInput() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = captureConsoleOutput(() -> exceptionHandling.handleException(1.0, 0.5));
        assertTrue(result.contains("Execution completed, whether exception was thrown or not."));
    }

    @Test
    void testProbablyIWillThrowException_noExceptionThrown() throws Exception {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 0.5));
    }
    @Test
    void testProbablyIWillThrowException_exceptionThrown_dueToX() {
        SecondChallenge secondChallenge = new SecondChallenge();
        Exception exception = assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.5, 0.9));
        assertEquals("Exception thrown: Invalid input values", exception.getMessage());
    }

    @Test
    void testProbablyIWillThrowException_exceptionThrown_dueToY() {
        SecondChallenge secondChallenge = new SecondChallenge();
        Exception exception = assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5));
        assertEquals("Exception thrown: Invalid input values", exception.getMessage());
    }

    @Test
    void testProbablyIWillThrowException_exceptionThrown_dueToBoth() {
        SecondChallenge secondChallenge = new SecondChallenge();
        Exception exception = assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.5, 1.5));
        assertEquals("Exception thrown: Invalid input values", exception.getMessage());
    }
}
