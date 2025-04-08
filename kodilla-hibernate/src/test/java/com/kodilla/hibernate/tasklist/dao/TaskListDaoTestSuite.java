package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    private static final String LIST_NAME = "Test List Name";
    private static final String DESCRIPTION = "Test List Description";

    @Test
    void testTaskListDaoFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(LIST_NAME);

        //Then
        assertEquals(1, readTaskLists.size());
        assertEquals(LIST_NAME, readTaskLists.get(0).getListName());
        assertEquals(DESCRIPTION, readTaskLists.get(0).getDescription());

        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}