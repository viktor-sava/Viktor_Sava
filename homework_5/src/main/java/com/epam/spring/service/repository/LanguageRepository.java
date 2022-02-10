package com.epam.spring.service.repository;

import com.epam.spring.service.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByShortName(String shortName);

    void deleteByShortName(String shortName);
}
