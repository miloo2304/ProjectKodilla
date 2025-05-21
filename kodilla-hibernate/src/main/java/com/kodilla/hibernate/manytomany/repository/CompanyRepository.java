package com.kodilla.hibernate.manytomany.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kodilla.hibernate.manytomany.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("FROM Company WHERE name LIKE :fragment")
    List<Company> findByFirstThreeCharacters(@Param("fragment") String fragment);
}

