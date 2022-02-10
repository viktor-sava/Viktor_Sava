package com.epam.spring.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    @Null(message = "'id' should be absent in request")
    private int id;

    @NotNull(message = "'product' shouldn't be empty")
    @Min(value = 0, message = "'price' shouldn't be negative")
    private BigDecimal price;

    @NotNull(message = "'amount' shouldn't be empty")
    @Min(value = 1, message = "'amount' shouldn't be less than 1")
    private Long amount;

    @NotNull(message = "'active' shouldn't be empty")
    private Boolean active;

    @NotNull(message = "'category' shouldn't be empty")
    private CategoryDto category;

    @NotNull(message = "'productDescriptionList' shouldn't be empty")
    private List<ProductDescriptionDto> productDescriptionList;

}
