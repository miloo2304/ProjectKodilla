package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value = "/findByLastName")
    public List<Employee> getByLastName(@RequestParam String lastname) {
        return employeeDao.findByLastName(lastname);
    }
}


