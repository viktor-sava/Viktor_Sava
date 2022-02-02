package com.epam.spring.service.model;

import com.epam.spring.controller.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(int id);

    ProductDto getProduct(String name);

    List<ProductDto> listProducts();

    ProductDto createProduct(ProductDto languageDto);

    ProductDto updateProduct(int id, ProductDto languageDto);

    void deleteProduct(int id);

}
