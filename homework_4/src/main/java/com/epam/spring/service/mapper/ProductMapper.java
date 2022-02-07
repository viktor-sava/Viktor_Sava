package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.ProductDto;
import com.epam.spring.service.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductDto mapProductDto(Product product);

    Product mapProduct(ProductDto productDto);

}
