package com.jornwer.urlshortener.web;

import com.jornwer.urlshortener.data.Urls;
import com.jornwer.urlshortener.data.UrlsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("{url:[a-zA-Z0-9]+}")
public class UrlController {

    private final UrlsService urlsService;

    public UrlController(UrlsService urlsService){
        this.urlsService = urlsService;
    }

    @GetMapping
    public String processUrl(@PathVariable("url") String url){
        Urls urls = urlsService.findUrlsByShortUrl(url);
        if (urls != null) {
            return String.format("redirect:%s", urls.getLongUrl());
        } else {
            return "error";
        }
    }
}
