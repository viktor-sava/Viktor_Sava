package com.epam.spring.service.repository;

import com.epam.spring.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p JOIN p.productDescriptionList pd WHERE pd.name=?1")
    Optional<Product> findByProductDescriptionName(String name);
}
