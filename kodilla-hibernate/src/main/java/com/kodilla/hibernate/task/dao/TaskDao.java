package com.kodilla.hibernate.task.dao;

import java.util.List;
import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {
List<Task> findByDuration(int duration);
}