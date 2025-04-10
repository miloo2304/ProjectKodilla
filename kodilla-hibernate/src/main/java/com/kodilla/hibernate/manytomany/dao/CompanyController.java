package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/companies")
public class CompanyController {

    @Autowired
    private CompanyDao companyDao;

    @GetMapping(value = "/findByPrefix")
    public List<Company> getByFirstThreeCharacters(@RequestParam String prefix) {
        return companyDao.findByFirstThreeCharacters(prefix);
    }
}

