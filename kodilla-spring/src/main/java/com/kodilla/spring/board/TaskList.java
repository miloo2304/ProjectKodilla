package com.kodilla.spring.board;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}