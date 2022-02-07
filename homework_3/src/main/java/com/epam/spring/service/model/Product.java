package com.epam.spring.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class Product {

    private int id;

    private BigDecimal price;

    private Long amount;

    private Timestamp createDate;

    private Timestamp updateDate;

    private Boolean active;

    private Category category;

    private List<ProductDescription> productDescriptionList;

}
