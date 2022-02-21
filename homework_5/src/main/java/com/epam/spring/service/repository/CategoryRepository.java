package com.epam.spring.service.repository;

import com.epam.spring.service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
