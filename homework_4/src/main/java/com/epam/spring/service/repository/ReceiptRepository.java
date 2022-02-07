package com.epam.spring.service.repository;

import com.epam.spring.service.model.Receipt;

import java.util.List;

public interface ReceiptRepository {

    Receipt getReceipt(int id);

    List<Receipt> listReceipts();

    Receipt createReceipt(Receipt receipt);

    Receipt updateReceipt(int id, Receipt receipt);
}
