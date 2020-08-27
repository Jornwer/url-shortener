package com.jornwer.urlshortener.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLsRepository extends JpaRepository<URLs, Long> {
    Optional<String> findLongURlByShortURL(String shortURL);
}
