package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.CategoryDto;
import com.epam.spring.exception.CategoryNotFoundException;
import com.epam.spring.service.CategoryService;
import com.epam.spring.service.mapper.CategoryMapper;
import com.epam.spring.service.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto getCategory(String name) {
        return categoryMapper.mapCategoryDto(categoryRepository.findByName(name)
                .orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public List<CategoryDto> listCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::mapCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return categoryMapper.mapCategoryDto(categoryRepository.save(categoryMapper.mapCategory(categoryDto)));
    }

    @Override
    public CategoryDto updateCategory(String name, CategoryDto categoryDto) {
        categoryDto.setName(name);
        return categoryMapper.mapCategoryDto(categoryRepository.save(categoryMapper.mapCategory(categoryDto)));
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.delete(categoryRepository.findByName(name).orElseThrow(CategoryNotFoundException::new));
    }
}
