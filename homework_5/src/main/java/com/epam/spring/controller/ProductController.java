package com.epam.spring.controller;

import com.epam.spring.controller.dto.ProductDescriptionDto;
import com.epam.spring.controller.dto.ProductDto;
import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import com.epam.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(required = false) String categoryName,
                                           @RequestParam(required = false) String language,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) Integer size,
                                           @RequestParam(required = false) String[] fields) {
        log.info("getAllProducts by categoryName (optional) {}, language (optional) {}", categoryName, language);
        return productService.listProducts(categoryName, language, page, size, fields);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/name/{name}")
    public ProductDto getProductByName(@PathVariable String name, @RequestParam(required = false) String language) {
        log.info("getProduct by name {}, language (optional) {}", name, language);
        return productService.getProduct(name, language);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ProductDto getProductById(@PathVariable int id, @RequestParam(required = false) String language) {
        log.info("getProduct by id {}, language (optional) {}", id, language);
        return productService.getProduct(id, language);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDto createProduct(@RequestBody @Validated(OnCreate.class) ProductDto productDto) {
        log.info("createProduct with name {}", productDto.getProductDescriptionList()
                .stream()
                .findFirst()
                .map(ProductDescriptionDto::getName));
        return productService.createProduct(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestBody @Validated(OnUpdate.class) ProductDto productDto) {
        log.info("updateProduct with id {}", id);
        return productService.updateProduct(id, productDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable int id) {
        log.info("deleteProduct by id {}", id);
        productService.deleteProduct(id);
    }

}
