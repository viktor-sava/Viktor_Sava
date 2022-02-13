package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.ProductDescriptionDto;
import com.epam.spring.controller.dto.ProductDto;
import com.epam.spring.service.ProductService;
import com.epam.spring.service.mapper.ProductMapper;
import com.epam.spring.service.model.Product;
import com.epam.spring.service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private static final Function<String, Predicate<ProductDescriptionDto>> isNotLanguagePredicate = l -> p ->
            !p.getLanguage()
                    .getShortName()
                    .equals(l);

    @Override
    public ProductDto getProduct(String name) {
        return productMapper.mapModelToDto(productRepository.getProduct(name));
    }

    @Override
    public ProductDto getProduct(int id) {
        return productMapper.mapModelToDto(productRepository.getProduct(id));
    }

    @Override
    public ProductDto getProduct(String name, String language) {
        ProductDto product = getProduct(name);
        product.getProductDescriptionList()
                .removeIf(isNotLanguagePredicate.apply(language));
        return product;
    }

    @Override
    public ProductDto getProduct(int id, String language) {
        ProductDto product = getProduct(id);
        product.getProductDescriptionList()
                .removeIf(isNotLanguagePredicate.apply(language));
        return product;
    }

    @Override
    public List<ProductDto> listProducts(String categoryName, String language) {
        List<Product> products = productRepository.listProducts();
        Optional.ofNullable(categoryName)
                .ifPresent((name) ->
                        products.removeIf(p -> !p.getCategory()
                                .getName()
                                .equals(name)));
        Optional.ofNullable(language)
                .ifPresent((lang) ->
                        products.removeIf(product -> product.getProductDescriptionList()
                                .removeIf(pd -> !pd.getLanguage()
                                        .getShortName()
                                        .equals(lang))));
        return products.stream()
                .map(productMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.info("Product with id {} was created", productDto.getId());
        return productMapper.mapModelToDto(productRepository.createProduct(productMapper.mapDtoToModel(productDto)));
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        productDto.setId(id);
        log.info("Product with id {} was updated", productDto.getId());
        return productMapper.mapModelToDto(productRepository.updateProduct(id, productMapper.mapDtoToModel(productDto)));
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
        log.info("Product with id {} was deleted", id);
    }
}
