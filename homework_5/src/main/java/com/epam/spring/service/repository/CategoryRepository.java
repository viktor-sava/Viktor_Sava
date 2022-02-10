package com.epam.spring.service.repository;

import com.epam.spring.service.model.Category;

import java.util.List;

public interface CategoryRepository {

    Category getCategory(String name);

    List<Category> listCategories();

    Category createCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);

}
