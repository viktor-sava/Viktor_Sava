package com.epam.spring.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class Receipt {

    private int id;

    private Timestamp createDate;

    private Timestamp updateDate;

    private BigDecimal generalPrice;

    private String address;

    private ReceiptStatus status;

    private List<ReceiptItem> receiptItemList;

    private User user;

}
