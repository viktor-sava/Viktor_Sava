package com.epam.spring.controller.dto;

import com.epam.spring.service.model.ReceiptStatus;
import com.epam.spring.service.model.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ReceiptDto {

    private int id;

    private BigDecimal generalPrice;

    private String address;

    private ReceiptStatus status;

    private List<ReceiptItemDto> receiptItemList;

    private User user;

}
