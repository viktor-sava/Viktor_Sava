package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.exception.ReceiptNotFoundException;
import com.epam.spring.exception.UserNotFoundException;
import com.epam.spring.service.ReceiptService;
import com.epam.spring.service.mapper.ReceiptMapper;
import com.epam.spring.service.model.Receipt;
import com.epam.spring.service.model.ReceiptStatus;
import com.epam.spring.service.repository.ReceiptRepository;
import com.epam.spring.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final UserRepository userRepository;
    private final ReceiptMapper receiptMapper;

    @Override
    public List<ReceiptDto> getReceipts(String email) {
        return receiptRepository.findAll().stream()
                .filter(p -> p.getUser().getEmail().equals(email))
                .map(receiptMapper::mapReceiptDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReceiptDto makeOrder(ReceiptDto receiptDto) {
        receiptDto.setStatus(ReceiptStatus.REGISTERED);
        Receipt receipt = receiptMapper.mapReceipt(receiptDto);
        receipt.setUser(userRepository.findByEmail(receiptDto.getEmail()).orElseThrow(UserNotFoundException::new));
        return receiptMapper.mapReceiptDto(receiptRepository.save(receipt));
    }

    @Override
    public void cancelReceipt(int id) {
        Receipt receipt = receiptRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
        receipt.setStatus(ReceiptStatus.CANCELED);
        receiptRepository.save(receipt);
    }

    @Override
    public void payReceipt(int id) {
        Receipt receipt = receiptRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
        receipt.setStatus(ReceiptStatus.PAID);
        receiptRepository.save(receipt);
    }
}
