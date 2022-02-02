package com.epam.spring.service.model;


import com.epam.spring.controller.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto getCategory(String name);

    List<CategoryDto> listCategories();

    CategoryDto createCategory(CategoryDto userDto);

    CategoryDto updateCategory(String name, CategoryDto userDto);

    void deleteCategory(String name);

}
