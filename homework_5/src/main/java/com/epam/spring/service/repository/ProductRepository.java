package com.epam.spring.service.repository;

import com.epam.spring.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p JOIN ProductDescription pd ON pd.id = p.id WHERE pd.name = ?1")
    Optional<Product> findByProductDescriptionName(String name);

    List<Product> findByCategoryName(String categoryName);
}
