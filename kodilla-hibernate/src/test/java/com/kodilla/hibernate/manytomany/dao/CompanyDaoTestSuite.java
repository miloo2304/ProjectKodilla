package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
           companyDao.deleteById(dataMaestersId);
           companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
    @Test
    void testFindByFirstThreeCharacters() {
        // Given
        Company company1 = new Company("ABC Technologies");
        Company company2 = new Company("ABC Solutions");
        Company company3 = new Company("DEF Innovations");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        // When
        List<Company> companiesWithPrefixABC = companyDao.findByFirstThreeCharacters("ABC");

        // Then
        assertEquals(2, companiesWithPrefixABC.size());
        assertTrue(companiesWithPrefixABC.stream().anyMatch(company -> company.getName().equals("ABC Technologies")));
        assertTrue(companiesWithPrefixABC.stream().anyMatch(company -> company.getName().equals("ABC Solutions")));

        // CleanUp
        companyDao.deleteAll();
    }

    @Test
    void testFindByFirstThreeCharacters_NoMatch() {
        // Given
        Company company1 = new Company("XYZ Enterprise");
        Company company2 = new Company("LMN Corporation");

        companyDao.save(company1);
        companyDao.save(company2);

        // When
        List<Company> companiesWithPrefixABC = companyDao.findByFirstThreeCharacters("ABC");

        // Then
        assertEquals(0, companiesWithPrefixABC.size());

        // CleanUp
        companyDao.deleteAll();
    }

}
