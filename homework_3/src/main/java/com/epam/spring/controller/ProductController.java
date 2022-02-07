package com.epam.spring.controller;

import com.epam.spring.controller.dto.ProductDto;
import com.epam.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(required = false) String categoryName,
                                           @RequestParam(required = false) String language) {
        if (categoryName == null) return productService.listProducts();
        return productService.getProducts(categoryName);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")
    public ProductDto getProduct(@PathVariable String name, @RequestParam(required = false) String language) {
        return language == null ? productService.getProduct(name) : productService.getProduct(name, language);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable int id, @RequestParam(required = false) String language) {
        return language == null ? productService.getProduct(id) : productService.getProduct(id, language);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
