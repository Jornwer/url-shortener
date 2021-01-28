package com.jornwer.urlshortener.web;

import com.jornwer.urlshortener.data.Urls;
import com.jornwer.urlshortener.data.UrlsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final UrlsService urlsService;

    public MainPageController(UrlsService urlsService){
        this.urlsService = urlsService;
    }

    @GetMapping("/")
    public String showMainForm(Model model){
        model.addAttribute("Urls", new Urls());
        return "index";
    }

    @PostMapping
    public String processURLs(@Valid Urls urls, Errors errors, Model model){
        if (errors.hasErrors()){
            return "index";
        }
        if (urlsService.saveURLs(urls) == null) {
            model.addAttribute("NonUniqueShortURL", true);
            return "index";
        } else {
            return "redirect:/";
        }
    }
}
