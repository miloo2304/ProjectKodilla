package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.repository.CompanyRepository;
import com.kodilla.hibernate.manytomany.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void cleanDatabaseBeforeTests() {
        companyRepository.deleteAll();
        employeeRepository.deleteAll();
    }

    @AfterEach
    void cleanDatabaseAfterTests() {
        companyRepository.deleteAll();
        employeeRepository.deleteAll();
    }

    @Test
    void testFindCompaniesByFragment() {

        Company company1 = new Company("Kodilla");
        Company company2 = new Company("Software Developers");
        Company company3 = new Company("Tech Solutions");

        companyRepository.save(company1);
        companyRepository.save(company2);
        companyRepository.save(company3);

        List<Company> foundCompanies = searchFacade.findCompaniesByFragment("Soft");

        assertThat(foundCompanies)
                .hasSize(1)
                .extracting(Company::getName)
                .containsExactly("Software Developers");
    }

    @Test
    void testFindEmployeesByFragment() {

        Employee employee1 = new Employee("John", "Smith");
        Employee employee2 = new Employee("Anna", "Smithson");
        Employee employee3 = new Employee("Mark", "Johnson");

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        List<Employee> foundEmployees = searchFacade.findEmployeesByFragment("Smith");

        assertThat(foundEmployees)
                .hasSize(2)
                .extracting(Employee::getLastname)
                .containsExactlyInAnyOrder("Smith", "Smithson");
    }
}
