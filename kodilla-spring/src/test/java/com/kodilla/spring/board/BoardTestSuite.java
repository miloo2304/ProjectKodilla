package com.kodilla.spring.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    void testTaskAdd() {
        board.getToDoList().addTask("To do task 1");
        board.getInProgressList().addTask("In progress task 1");
        board.getDoneList().addTask("Done task 1");

        assertEquals("To do task 1", board.getToDoList().getTasks().get(0));
        assertEquals("In progress task 1", board.getInProgressList().getTasks().get(0));
        assertEquals("Done task 1", board.getDoneList().getTasks().get(0));
    }
}