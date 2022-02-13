package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.service.model.ReceiptStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiptDto {

    @Null(message = "'id' should be absent in request", groups = OnCreate.class)
    private Integer id;

    @Null(message = "'generalPrice' should be absent in request", groups = OnCreate.class)
    private BigDecimal generalPrice;

    @NotNull(message = "'address' shouldn't be empty", groups = OnCreate.class)
    private String address;

    @Null(message = "'generalPrice' should be absent in request", groups = OnCreate.class)
    private ReceiptStatus status;

    @NotNull(message = "'receiptItemList' shouldn't be empty", groups = OnCreate.class)
    private List<ReceiptItemDto> receiptItemList;

    @NotNull(message = "'email' shouldn't be empty", groups = OnCreate.class)
    @Email
    private String email;

}
