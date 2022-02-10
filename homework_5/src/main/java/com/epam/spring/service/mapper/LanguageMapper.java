package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.LanguageDto;
import com.epam.spring.service.model.Language;
import org.mapstruct.Mapper;

@Mapper
public interface LanguageMapper {

    LanguageDto mapLanguageDto(Language product);

    Language mapLanguage(LanguageDto productDto);

}
