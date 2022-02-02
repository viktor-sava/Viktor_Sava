package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class ReceiptDto {

    private int id;

    private Timestamp createDate;

    private Timestamp updateDate;

    private List<ReceiptItemDto> receiptItemList;

}
