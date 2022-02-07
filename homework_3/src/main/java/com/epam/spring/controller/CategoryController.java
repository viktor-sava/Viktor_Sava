package com.epam.spring.controller;

import com.epam.spring.controller.dto.CategoryDto;
import com.epam.spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.listCategories();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    public CategoryDto getCategory(@PathVariable String name) {
        return categoryService.getCategory(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{name}")
    public CategoryDto updateCategory(@PathVariable String name, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(name, categoryDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteCategory(@PathVariable String name) {
        categoryService.deleteCategory(name);
    }

}
