package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.service.model.Receipt;
import org.mapstruct.Mapper;

@Mapper
public interface ReceiptMapper {

    ReceiptDto mapReceiptDto(Receipt receipt);

    Receipt mapReceipt(ReceiptDto receiptDto);

}
