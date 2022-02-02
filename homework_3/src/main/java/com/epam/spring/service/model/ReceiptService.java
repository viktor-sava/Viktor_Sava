package com.epam.spring.service.model;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.controller.dto.UserDto;

import java.util.List;

public interface ReceiptService {

    ReceiptDto getReceipt(int id);

    ReceiptDto getReceipt(ReceiptDto receiptDto);

    List<ReceiptDto> listReceipts();

    ReceiptDto createReceipt(ReceiptDto receiptDto);

    ReceiptDto updateReceipt(int id, ReceiptDto receiptDto);

    void deleteReceipt(int id);

}
