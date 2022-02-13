package com.epam.spring.controller;

import com.epam.spring.controller.dto.CategoryDto;
import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import com.epam.spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CategoryDto> getAllCategories() {
        log.info("getAllCategories");
        return categoryService.listCategories();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    public CategoryDto getCategoryByName(@PathVariable String name) {
        log.info("getCategory by name {}", name);
        return categoryService.getCategory(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryDto createCategory(@RequestBody @Validated(OnCreate.class) CategoryDto categoryDto) {
        log.info("createCategory with name {}", categoryDto.getName());
        return categoryService.createCategory(categoryDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{name}")
    public CategoryDto updateCategory(@PathVariable String name, @RequestBody @Validated(OnUpdate.class) CategoryDto categoryDto) {
            log.info("updateCategory with name {}", name);
            return categoryService.updateCategory(name, categoryDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteCategory(@PathVariable String name) {
        log.info("deleteCategory by name {}", name);
        categoryService.deleteCategory(name);
    }

}
