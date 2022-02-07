package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.LanguageDto;
import com.epam.spring.service.LanguageService;
import com.epam.spring.service.mapper.LanguageMapper;
import com.epam.spring.service.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Override
    public LanguageDto getLanguage(String shortName) {
        return languageMapper.mapLanguageDto(languageRepository.getLanguage(shortName));
    }

    @Override
    public List<LanguageDto> listLanguages() {
        return languageRepository.listLanguages().stream()
                .map(languageMapper::mapLanguageDto)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {
        return languageMapper
                .mapLanguageDto(languageRepository.createLanguage(languageMapper.mapLanguage(languageDto)));
    }

    @Override
    public LanguageDto updateLanguage(String shortName, LanguageDto languageDto) {
        return languageMapper
                .mapLanguageDto(languageRepository.updateLanguage(shortName, languageMapper.mapLanguage(languageDto)));
    }

    @Override
    public void deleteLanguage(String shortName) {
        languageRepository.deleteLanguage(shortName);
    }
}
