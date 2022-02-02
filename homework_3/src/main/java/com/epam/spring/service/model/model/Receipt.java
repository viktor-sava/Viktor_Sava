package com.epam.spring.service.model.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class Receipt {

    private int id;

    private Timestamp createDate;

    private Timestamp updateDate;

    private List<ReceiptItem> receiptItemList;

}
