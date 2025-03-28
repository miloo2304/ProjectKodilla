package com.kodilla.patterns.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task createTask(String taskType) {
        return switch (taskType) {
            case SHOPPING -> new ShoppingTask("Buy candies", "Haribo", 10.0);
            case PAINTING -> new PaintingTask("Paint wall", "Blue", "Wall in the living room");
            case DRIVING -> new DrivingTask("Drive to office", "Office", "Car");
            default -> null;
        };
    }
}
