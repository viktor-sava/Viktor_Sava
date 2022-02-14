package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    @Null(message = "'ProductDto.id' should be absent in request", groups = OnCreate.class)
    private Integer id;

    @NotNull(message = "'product' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @PositiveOrZero(message = "'price' shouldn't be negative", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal price;

    @NotNull(message = "'amount' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "'amount' must not be less than 1", groups = {OnCreate.class, OnUpdate.class})
    private Long amount;

    @NotNull(message = "'active' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private Boolean active;

    @NotNull(message = "'category' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private CategoryDto category;

    @NotNull(message = "'productDescriptionList' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private List<ProductDescriptionDto> productDescriptionList;

}
