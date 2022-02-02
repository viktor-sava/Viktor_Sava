package com.epam.spring.service.model;

import com.epam.spring.controller.dto.LanguageDto;

import java.util.List;

public interface LanguageService {

    LanguageDto getLanguage(String shortName);

    List<LanguageDto> listLanguages();

    LanguageDto createLanguage(LanguageDto languageDto);

    LanguageDto updateLanguage(String shortName, LanguageDto languageDto);

    void deleteLanguage(String shortName);

}
