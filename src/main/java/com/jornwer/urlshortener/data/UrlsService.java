package com.jornwer.urlshortener.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlsService {

    private final UrlsRepository urlsRepository;

    @Autowired
    public UrlsService(UrlsRepository urlsRepository){
        this.urlsRepository = urlsRepository;
    }

    public Urls findUrlsByShortUrl(String shortUrl){
        return urlsRepository.findUrlsByShortUrl(shortUrl).orElse(null);
    }

    public Urls saveURLs(Urls urls){
        return findUrlsByShortUrl(urls.getShortUrl()) == null ? urlsRepository.save(urls) : null;
    }
}
