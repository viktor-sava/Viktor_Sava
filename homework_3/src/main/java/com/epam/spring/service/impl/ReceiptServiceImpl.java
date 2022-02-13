package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.service.ReceiptService;
import com.epam.spring.service.mapper.ReceiptMapper;
import com.epam.spring.service.model.Receipt;
import com.epam.spring.service.model.ReceiptStatus;
import com.epam.spring.service.repository.ReceiptRepository;
import com.epam.spring.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final UserRepository userRepository;
    private final ReceiptMapper receiptMapper;

    @Override
    public List<ReceiptDto> getReceipts(String email) {
        return receiptRepository.listReceipts()
                .stream()
                .filter(p -> p.getUser()
                        .getEmail()
                        .equals(email))
                .map(receiptMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReceiptDto makeOrder(ReceiptDto receiptDto) {
        receiptDto.setStatus(ReceiptStatus.REGISTERED);
        Receipt receipt = receiptMapper.mapDtoToModel(receiptDto);
        receipt.setUser(userRepository.getUser(receiptDto.getEmail()));
        log.info("Receipt with id {} was created", receiptDto.getId());
        return receiptMapper.mapModelToDto(receiptRepository.createReceipt(receipt));
    }

    @Override
    public void cancelReceipt(int id) {
        Receipt receipt = receiptRepository.getReceipt(id);
        receipt.setStatus(ReceiptStatus.CANCELED);
        receiptRepository.updateReceipt(id, receipt);
        log.info("Receipt with id {} was canceled", id);
    }

    @Override
    public void payReceipt(int id) {
        Receipt receipt = receiptRepository.getReceipt(id);
        receipt.setStatus(ReceiptStatus.PAID);
        receiptRepository.updateReceipt(id, receipt);
        log.info("Receipt with id {} was paid", id);
    }
}
