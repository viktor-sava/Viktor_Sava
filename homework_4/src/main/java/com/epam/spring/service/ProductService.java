package com.epam.spring.service;

import com.epam.spring.controller.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(String name);

    ProductDto getProduct(int id);

    ProductDto getProduct(String name, String language);

    ProductDto getProduct(int id, String language);

    List<ProductDto> getProducts(String categoryName);

    List<ProductDto> getProducts(String categoryName, String language);

    List<ProductDto> listProducts();

    List<ProductDto> listProducts(String language);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(int id, ProductDto productDto);

    void deleteProduct(int id);

}
