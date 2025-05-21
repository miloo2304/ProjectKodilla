package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.repository.CompanyRepository;
import com.kodilla.hibernate.manytomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchFacade {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Company> findCompaniesByFragment(String nameFragment) {
        return companyRepository.findByFirstThreeCharacters("%" + nameFragment + "%");
    }

    public List<Employee> findEmployeesByFragment(String lastNameFragment) {
        return employeeRepository.findByLastName("%" + lastNameFragment + "%");
    }
}
