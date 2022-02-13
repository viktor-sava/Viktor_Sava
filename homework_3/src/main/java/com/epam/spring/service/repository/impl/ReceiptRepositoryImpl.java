package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.ReceiptNotFoundException;
import com.epam.spring.service.model.Receipt;
import com.epam.spring.service.repository.ReceiptRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository {

    private final List<Receipt> receiptList = new ArrayList<>();

    private static final Function<Integer, Predicate<Receipt>> isReceiptEqualsPredicate = l -> p -> p.getId() == l;

    @Override
    public Receipt getReceipt(int id) {
        return receiptList.stream()
                .filter(isReceiptEqualsPredicate.apply(id))
                .findFirst()
                .orElseThrow(() -> new ReceiptNotFoundException(id));
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
        Receipt oldReceipt = receiptList.stream()
                .filter(isReceiptEqualsPredicate.apply(id))
                .findFirst()
                .orElseThrow(() -> new ReceiptNotFoundException(id));
        receiptList.remove(oldReceipt);
        receipt.setCreateDate(oldReceipt.getCreateDate());
        receipt.setId(oldReceipt.getId());
        receipt.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
        receiptList.add(receipt);
        return receipt;
    }
}
