package com.jornwer.urlshortener.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLsService {

    private final URLsRepository urlsRepository;

    @Autowired
    public URLsService(URLsRepository urlsRepository){
        this.urlsRepository = urlsRepository;
    }

    public String findLongURlByShortURL(String shortURL){
        return urlsRepository.findLongURlByShortURL(shortURL).orElse(null);
    }

    public URLs saveURLs(URLs urls){
        return urlsRepository.save(urls);
    }
}
