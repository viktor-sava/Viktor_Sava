package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.LanguageDto;
import com.epam.spring.exception.EntityExistsException;
import com.epam.spring.exception.LanguageNotFoundException;
import com.epam.spring.service.LanguageService;
import com.epam.spring.service.mapper.LanguageMapper;
import com.epam.spring.service.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Override
    public LanguageDto getLanguage(String shortName) {
        return languageMapper.mapModelToDto(languageRepository.findByShortName(shortName)
                .orElseThrow(() -> new LanguageNotFoundException(shortName)));
    }

    @Override
    public List<LanguageDto> listLanguages() {
        return languageRepository.findAll()
                .stream()
                .map(languageMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {
        if (languageRepository.existsByShortName(languageDto.getShortName())) {
            throw new EntityExistsException("Language with such shortName already exists");
        }
        log.info("Language with shortName {}, fullName {} was created",
                languageDto.getShortName(), languageDto.getFullName());
        return languageMapper
                .mapModelToDto(languageRepository.save(languageMapper.mapDtoToModel(languageDto)));
    }

    @Override
    public LanguageDto updateLanguage(String shortName, LanguageDto languageDto) {
        if (!languageRepository.existsByShortName(shortName)) {
            throw new LanguageNotFoundException(shortName);
        }
        log.info("Language with shortName {}, fullName {} was updated", languageDto.getShortName(), languageDto.getFullName());
        return languageMapper
                .mapModelToDto(languageRepository.save(languageMapper.mapDtoToModel(languageDto)));
    }

    @Override
    public void deleteLanguage(String shortName) {
        log.info("Language with shortName {} was deleted", shortName);
        languageRepository.deleteByShortName(shortName);
    }
}
