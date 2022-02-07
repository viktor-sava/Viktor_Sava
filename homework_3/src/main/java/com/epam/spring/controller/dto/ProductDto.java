package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class ProductDto {

    private int id;

    private BigDecimal price;

    private Long amount;

    private Boolean active;

    private String categoryName;

    private List<ProductDescriptionDto> productDescriptionList;

}
