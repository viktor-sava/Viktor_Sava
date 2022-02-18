package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.CategoryNotFoundException;
import com.epam.spring.exception.EntityExistsException;
import com.epam.spring.service.model.Category;
import com.epam.spring.service.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final List<Category> categoryList = new ArrayList<>();

    private static final Function<Integer, Predicate<Category>> isCategoryEqualsPredicate = l -> p -> p.getId() == l;

    @Override
    public Category getCategory(String name) {
        return categoryList.stream()
                .filter(p -> p.getName()
                        .equals(name))
                .findFirst()
                .orElseThrow(() -> new CategoryNotFoundException(name));
    }

    @Override
    public List<Category> listCategories() {
        return new ArrayList<>(categoryList);
    }

    @Override
    public Category createCategory(Category category) {
        if (categoryList.stream()
                .anyMatch(p -> p.getName()
                        .equals(category.getName()))) {
            throw new EntityExistsException("Category with this name already exists");
        }
        category.setId(categoryList.size() + 1);
        category.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        categoryList.add(category);
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category oldCategory = categoryList.stream()
                .filter(isCategoryEqualsPredicate.apply(id))
                .findFirst()
                .orElseThrow(() -> new CategoryNotFoundException(id));
        categoryList.remove(oldCategory);
        category.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        category.setId(oldCategory.getId());
        categoryList.add(category);
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        categoryList.removeIf(isCategoryEqualsPredicate.apply(id));
    }
}
