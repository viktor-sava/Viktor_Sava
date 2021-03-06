package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.CategoryDto;
import com.epam.spring.service.model.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDto mapModelToDto(Category category);

    Category mapDtoToModel(CategoryDto categoryDto);

}
