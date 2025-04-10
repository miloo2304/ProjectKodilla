package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import java.math.BigDecimal;

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
    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LIST_NAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        //taskListDao.deleteById(id);
        taskListDao.deleteAll();
    }
}