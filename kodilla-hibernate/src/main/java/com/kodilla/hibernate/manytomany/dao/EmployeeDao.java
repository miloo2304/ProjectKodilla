package com.kodilla.hibernate.manytomany.dao;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee WHERE lastname = :LASTNAME")
    List<Employee> findByLastName(@Param("LASTNAME") String lastname);

}
