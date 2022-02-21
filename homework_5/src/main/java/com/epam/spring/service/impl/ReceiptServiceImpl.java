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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        return receiptRepository.findAll()
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
        receipt.setGeneralPrice(receiptDto.getReceiptItemList()
                .stream()
                .map(r -> r.getProduct()
                        .getPrice()
                        .multiply(BigDecimal.valueOf(r.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        receipt.setUser(userRepository.findByEmail(receiptDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException(receiptDto.getEmail())));
        log.info("Receipt with id {} was created", receiptDto.getId());
        return receiptMapper.mapModelToDto(receiptRepository.save(receipt));
    }

    @Override
    public void cancelReceipt(int id) {
        Receipt receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new ReceiptNotFoundException(id));
        receipt.setStatus(ReceiptStatus.CANCELED);
        receiptRepository.save(receipt);
        log.info("Receipt with id {} was canceled", id);
    }

    @Override
    public void payReceipt(int id) {
        Receipt receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new ReceiptNotFoundException(id));
        receipt.setStatus(ReceiptStatus.PAID);
        receiptRepository.save(receipt);
        log.info("Receipt with id {} was paid", id);
    }
}
