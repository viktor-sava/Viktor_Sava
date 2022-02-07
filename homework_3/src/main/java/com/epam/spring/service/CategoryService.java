package com.epam.spring.service;

import com.epam.spring.controller.dto.CategoryDto;
import com.epam.spring.controller.dto.LanguageDto;

import java.util.List;

public interface CategoryService {

    CategoryDto getCategory(String name);

    List<CategoryDto> listCategories();

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(String name, CategoryDto categoryDto);

    void deleteCategory(String name);

}
