package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.CategoryNotFoundException;
import com.epam.spring.exception.ReceiptNotFoundException;
import com.epam.spring.service.model.Category;
import com.epam.spring.service.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final List<Category> categoryList = new ArrayList<>();

    @Override
    public Category getCategory(String name) {
        Optional<Category> optional = categoryList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
        if (!optional.isPresent()) {
            throw new CategoryNotFoundException();
        }
        return optional.get();
    }

    @Override
    public List<Category> listCategories() {
        return new ArrayList<>(categoryList);
    }

    @Override
    public Category createCategory(Category category) {
        category.setId(categoryList.size() + 1);
        category.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        categoryList.add(category);
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Optional<Category> optional = categoryList.stream().filter(p -> p.getId() == id).findFirst();
        if (!optional.isPresent()) {
            throw new ReceiptNotFoundException();
        }
        categoryList.removeIf(p -> p.getId() == id);
        Category oldCategory = optional.get();
        category.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        category.setId(oldCategory.getId());
        categoryList.add(category);
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        categoryList.removeIf(p -> p.getId() == id);
    }
}
