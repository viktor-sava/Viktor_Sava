package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.ProductDto;
import com.epam.spring.service.ProductService;
import com.epam.spring.service.mapper.ProductMapper;
import com.epam.spring.service.model.Product;
import com.epam.spring.service.model.ProductDescription;
import com.epam.spring.service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProduct(String name) {
        Product product = productRepository.getProduct(name);
        ProductDto productDto = productMapper.mapProductDto(product);
        productDto.setCategoryName(product.getCategory().getName());
        return productDto;
    }

    @Override
    public ProductDto getProduct(int id) {
        return productMapper.mapProductDto(productRepository.getProduct(id));
    }

    @Override
    public List<ProductDto> getProducts(String categoryName) {
        return productRepository.listProducts().stream()
                .filter(p -> p.getCategory().getName().equals(categoryName))
                .map(productMapper::mapProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> listProducts() {
        return productRepository.listProducts().stream()
                .map(productMapper::mapProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return productMapper.mapProductDto(productRepository.createProduct(productMapper.mapProduct(productDto)));
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        productDto.setId(id);
        return productMapper.mapProductDto(productRepository.updateProduct(id, productMapper.mapProduct(productDto)));
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }
}
