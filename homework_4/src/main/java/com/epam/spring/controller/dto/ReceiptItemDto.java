package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ReceiptItemDto {

    @NotNull(message = "'product' shouldn't be empty")
    private ProductDto product;

    @NotNull(message = "'quantity' shouldn't be empty")
    @Min(value = 1, message = "'quantity' shouldn't be less than 1")
    private Integer quantity;

}
