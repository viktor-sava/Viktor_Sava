package com.epam.spring.controller;

import com.epam.spring.controller.dto.LanguageDto;
import com.epam.spring.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
@Slf4j
public class LanguageController {

    private final LanguageService languageService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<LanguageDto> getAllLanguages() {
        log.info("getAllLanguages");
        return languageService.listLanguages();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{shortName}")
    public LanguageDto getLanguageByShortName(@PathVariable String shortName) {
        log.info("getLanguage by shortName {}", shortName);
        return languageService.getLanguage(shortName);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LanguageDto createLanguage(@RequestBody LanguageDto languageDto) {
        log.info("createLanguage with shortName {}, fullName {}", languageDto.getShortName(), languageDto.getFullName());
        return languageService.createLanguage(languageDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{shortName}")
    public LanguageDto updateLanguage(@PathVariable String shortName, @RequestBody LanguageDto languageDto) {
        log.info("updateLanguage with shortName {}", shortName);
        return languageService.updateLanguage(shortName, languageDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{shortName}")
    public void deleteLanguage(@PathVariable String shortName) {
        log.info("deleteLanguage by shortName {}", shortName);
        languageService.deleteLanguage(shortName);
    }

}
