package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.ReceiptNotFoundException;
import com.epam.spring.service.model.Receipt;
import com.epam.spring.service.repository.ReceiptRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReceiptRepositoryImpl implements ReceiptRepository {

    private final List<Receipt> receiptList = new ArrayList<>();

    @Override
    public Receipt getReceipt(int id) {
        Optional<Receipt> optionalReceipt = receiptList.stream().filter(p -> p.getId() == id).findFirst();
        if (!optionalReceipt.isPresent()) {
            throw new ReceiptNotFoundException(id);
        }
        return optionalReceipt.get();
    }

    @Override
    public List<Receipt> listReceipts() {
        return new ArrayList<>(receiptList);
    }

    @Override
    public Receipt createReceipt(Receipt receipt) {
        receipt.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        receipt.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        receipt.setId(receiptList.size() + 1);
        receiptList.add(receipt);
        return receipt;
    }

    @Override
    public Receipt updateReceipt(int id, Receipt receipt) {
        Optional<Receipt> optional = receiptList.stream().filter(p -> p.getId() == id).findFirst();
        if (!optional.isPresent()) {
            throw new ReceiptNotFoundException(id);
        }
        receiptList.removeIf(p -> p.getId() == id);
        Receipt oldReceipt = optional.get();
        receipt.setCreateDate(oldReceipt.getCreateDate());
        receipt.setId(oldReceipt.getId());
        receipt.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        receiptList.add(receipt);
        return receipt;
    }
}
