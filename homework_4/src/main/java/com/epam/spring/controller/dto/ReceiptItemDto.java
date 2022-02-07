package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptItemDto {

    private ProductDto product;

    private Integer quantity;

}
