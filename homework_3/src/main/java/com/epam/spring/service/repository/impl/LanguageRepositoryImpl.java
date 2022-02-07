package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.LanguageNotFoundException;
import com.epam.spring.exception.ProductNotFoundException;
import com.epam.spring.exception.ReceiptNotFoundException;
import com.epam.spring.service.model.Language;
import com.epam.spring.service.model.Product;
import com.epam.spring.service.model.Receipt;
import com.epam.spring.service.repository.LanguageRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    private final List<Language> languageList = new ArrayList<>();

    @Override
    public Language getLanguage(String shortName) {
        Optional<Language> optional = languageList.stream()
                .filter(p -> p.getShortName().equals(shortName))
                .findFirst();
        if (!optional.isPresent()) {
            throw new LanguageNotFoundException();
        }
        return optional.get();
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
        Optional<Language> optional = languageList.stream().filter(p -> p.getShortName().equals(shortName)).findFirst();
        if (!optional.isPresent()) {
            throw new ReceiptNotFoundException();
        }
        languageList.removeIf(p -> p.getShortName().equals(shortName));
        Language oldLanguage = optional.get();
        language.setId(oldLanguage.getId());
        languageList.add(language);
        return language;
    }

    @Override
    public void deleteLanguage(String shortName) {
        languageList.removeIf(p -> p.getShortName().equals(shortName));
    }
}
