package com.kodilla.hibernate.invoice.dao;

import org.springframework.data.repository.CrudRepository;
import com.kodilla.hibernate.invoice.Product;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
