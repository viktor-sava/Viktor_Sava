package com.epam.spring.controller;

import com.epam.spring.controller.dto.LanguageDto;
import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<LanguageDto> getAllLanguages() {
        return languageService.listLanguages();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{shortName}")
    public LanguageDto getLanguage(@PathVariable String shortName) {
        return languageService.getLanguage(shortName);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LanguageDto createLanguage(@RequestBody LanguageDto languageDto) {
        return languageService.createLanguage(languageDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{shortName}")
    public LanguageDto updateLanguage(@PathVariable String shortName, @RequestBody LanguageDto languageDto) {
        return languageService.updateLanguage(shortName, languageDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{shortName}")
    public void deleteLanguage(@PathVariable String shortName) {
        languageService.deleteLanguage(shortName);
    }

}
