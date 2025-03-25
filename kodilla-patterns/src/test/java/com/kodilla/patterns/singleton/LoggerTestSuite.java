package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        // Given
        Logger logger = Logger.INSTANCE;
        logger.log("Test log message");
        // When
        String lastLog = logger.getLastLog();
        // Then
        assertEquals("Test log message", lastLog);
    }
}

