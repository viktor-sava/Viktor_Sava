package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.service.ReceiptService;
import com.epam.spring.service.mapper.ReceiptMapper;
import com.epam.spring.service.model.Receipt;
import com.epam.spring.service.model.ReceiptStatus;
import com.epam.spring.service.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    @Override
    public List<ReceiptDto> getReceipts(String email) {
        return receiptRepository.listReceipts().stream()
                .filter(p -> p.getUser().getEmail().equals(email))
                .map(receiptMapper::mapReceiptDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReceiptDto makeOrder(ReceiptDto receiptDto) {
        receiptDto.setStatus(ReceiptStatus.REGISTERED);
        return receiptMapper.mapReceiptDto(receiptRepository.createReceipt(receiptMapper.mapReceipt(receiptDto)));
    }

    @Override
    public void cancelReceipt(int id) {
        Receipt receipt = receiptRepository.getReceipt(id);
        receipt.setStatus(ReceiptStatus.CANCELED);
        receiptRepository.updateReceipt(id, receipt);
    }

    @Override
    public void payReceipt(int id) {
        Receipt receipt = receiptRepository.getReceipt(id);
        receipt.setStatus(ReceiptStatus.PAID);
        receiptRepository.updateReceipt(id, receipt);
    }
}
