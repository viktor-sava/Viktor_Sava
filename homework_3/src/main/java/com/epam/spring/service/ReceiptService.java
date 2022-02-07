package com.epam.spring.service;

import com.epam.spring.controller.dto.ReceiptDto;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDto> getReceipts(String email);

    ReceiptDto makeOrder(ReceiptDto receiptDto);

    void cancelReceipt(int id);

    void paidReceipt(int id);

}
