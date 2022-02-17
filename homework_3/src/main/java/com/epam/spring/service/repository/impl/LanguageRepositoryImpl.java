package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.LanguageNotFoundException;
import com.epam.spring.service.model.Language;
import com.epam.spring.service.repository.LanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    private final List<Language> languageList = new ArrayList<>();

    private final Function<String, Predicate<Language>> isLanguageShortNameEquals = s -> p -> p.getShortName()
            .equals(s);

    @Override
    public Language getLanguage(String shortName) {
        return languageList.stream()
                .filter(isLanguageShortNameEquals.apply(shortName))
                .findFirst()
                .orElseThrow(() -> new LanguageNotFoundException(shortName));
    }

    @Override
    public List<Language> listLanguages() {
        return new ArrayList<>(languageList);
    }

    @Override
    public Language createLanguage(Language language) {
        language.setId(languageList.size() + 1);
        languageList.add(language);
        return language;
    }

    @Override
    public Language updateLanguage(String shortName, Language language) {
        Language oldLanguage = languageList.stream()
                .filter(isLanguageShortNameEquals.apply(shortName))
                .findFirst()
                .orElseThrow(() -> new LanguageNotFoundException(shortName));
        languageList.remove(oldLanguage);
        language.setId(oldLanguage.getId());
        languageList.add(language);
        return language;
    }

    @Override
    public void deleteLanguage(String shortName) {
        languageList.removeIf(isLanguageShortNameEquals.apply(shortName));
    }
}
