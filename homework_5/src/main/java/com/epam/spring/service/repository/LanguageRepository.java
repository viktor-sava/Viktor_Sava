package com.epam.spring.service.repository;

import com.epam.spring.service.model.Language;

import java.util.List;

public interface LanguageRepository {

    Language getLanguage(String shortName);

    List<Language> listLanguages();

    Language createLanguage(Language language);

    Language updateLanguage(String shortName, Language language);

    void deleteLanguage(String shortName);
}
