package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ReceiptItemDto {

    @NotNull(message = "'product' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private ProductDto product;

    @NotNull(message = "'quantity' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 1, message = "'quantity' shouldn't be less than 1", groups = {OnCreate.class, OnUpdate.class})
    private Integer quantity;

}
