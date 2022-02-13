package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.service.model.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ReceiptMapper {

    @Mappings({
            @Mapping(target="email", source="receipt.user.email")
    })
    ReceiptDto mapModelToDto(Receipt receipt);

    Receipt mapDtoToModel(ReceiptDto receiptDto);

}
