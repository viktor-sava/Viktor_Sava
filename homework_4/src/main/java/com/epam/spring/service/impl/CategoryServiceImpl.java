package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.CategoryDto;
import com.epam.spring.service.CategoryService;
import com.epam.spring.service.mapper.CategoryMapper;
import com.epam.spring.service.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto getCategory(String name) {
        return categoryMapper.mapModelToDto(categoryRepository.getCategory(name));
    }

    @Override
    public List<CategoryDto> listCategories() {
        return categoryRepository.listCategories()
                .stream()
                .map(categoryMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        log.info("Category with id {} was created", categoryDto.getId());
        return categoryMapper.mapModelToDto(categoryRepository.createCategory(categoryMapper.mapDtoToModel(categoryDto)));
    }

    @Override
    public CategoryDto updateCategory(String name, CategoryDto categoryDto) {
        log.info("Category with id {} was updated", categoryDto.getId());
        return categoryMapper.mapModelToDto(
                categoryRepository.updateCategory(
                        categoryRepository.getCategory(name)
                                .getId(),
                        categoryMapper.mapDtoToModel(categoryDto)
                ));
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteCategory(categoryRepository.getCategory(name)
                .getId());
        log.info("Category with name {} was deleted", name);
    }
}
