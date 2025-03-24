package com.kodilla.spring.board;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BoardConfig {
    @Bean
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean
    public TaskList doneList() {
        return new TaskList();
    }

    @Bean
    public Board board() {
        return new Board(toDoList(), inProgressList(), doneList());
    }
}

