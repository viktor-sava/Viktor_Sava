package com.epam.spring.service;

import com.epam.spring.controller.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(String name);

    ProductDto getProduct(int id);

    List<ProductDto> getProducts(String categoryName);

    List<ProductDto> listProducts();

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(int id, ProductDto productDto);

    void deleteProduct(int id);

}
