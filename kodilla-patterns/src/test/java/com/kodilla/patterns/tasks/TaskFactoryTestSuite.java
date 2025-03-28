package com.kodilla.patterns.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testTaskFactoryShoppingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING);

        assertNotNull(shoppingTask);
        assertEquals("Buy candies", shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());
        shoppingTask.executeTask();
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testTaskFactoryPaintingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING);

        assertNotNull(paintingTask);
        assertEquals("Paint wall", paintingTask.getTaskName());
        assertFalse(paintingTask.isTaskExecuted());
        paintingTask.executeTask();
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testTaskFactoryDrivingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING);

        assertNotNull(drivingTask);
        assertEquals("Drive to office", drivingTask.getTaskName());
        assertFalse(drivingTask.isTaskExecuted());
        drivingTask.executeTask();
        assertTrue(drivingTask.isTaskExecuted());
    }
}

