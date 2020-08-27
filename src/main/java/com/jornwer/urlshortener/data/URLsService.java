package com.jornwer.urlshortener.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class URLsService {

    private final URLsRepository urlsRepository;

    @Autowired
    public URLsService(URLsRepository urlsRepository){
        this.urlsRepository = urlsRepository;
    }

    public URLs findURlsByShortURL(String shortURL){
        return urlsRepository.findURlsByShortURL(shortURL).orElse(null);
    }

    public URLs saveURLs(URLs urls){
        return findURlsByShortURL(urls.getShortURL()) == null ? urlsRepository.save(urls) : null;
    }

}
