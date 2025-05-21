package com.kodilla.hibernate.manytomany.repository;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee WHERE lastname LIKE :fragment")
    List<Employee> findByLastName(@Param("fragment") String fragment);
}


