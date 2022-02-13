package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.service.model.Receipt;
import org.mapstruct.Mapper;

@Mapper
public interface ReceiptMapper {

    ReceiptDto mapModelToDto(Receipt receipt);

    Receipt mapDtoToModel(ReceiptDto receiptDto);

}
