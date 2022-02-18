package com.epam.spring.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptItem {

    private Product product;

    private Integer quantity;

}
