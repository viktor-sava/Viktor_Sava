package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ReceiptItemDto {

    @NotNull(message = "'product' shouldn't be empty", groups = OnCreate.class)
    private ProductDto product;

    @NotNull(message = "'product' shouldn't be empty", groups = OnCreate.class)
    private Integer quantity;

}
