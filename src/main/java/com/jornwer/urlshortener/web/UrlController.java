package com.jornwer.urlshortener.web;

import com.jornwer.urlshortener.data.URLs;
import com.jornwer.urlshortener.data.URLsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("{url:[a-zA-Z0-9]+}")
public class UrlController {

    private final URLsService urlsService;

    public UrlController(URLsService urlsService){
        this.urlsService = urlsService;
    }

    @GetMapping
    public String processUrl(@PathVariable("url") String url){
        URLs urls = urlsService.findURlsByShortURL(url);
        if (urls != null) {
            return String.format("redirect:%s", urls.getLongURL());
        } else {
            return "error";
        }
    }
}
