package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(name = "Company.findByFirstThreeCharacters")
    List<Company> findByFirstThreeCharacters(@Param("PREFIX") String prefix);
}

