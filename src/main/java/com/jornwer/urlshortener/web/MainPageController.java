package com.jornwer.urlshortener.web;

import com.jornwer.urlshortener.data.URLs;
import com.jornwer.urlshortener.data.URLsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final URLsService urlsService;

    public MainPageController(URLsService urlsService){
        this.urlsService = urlsService;
    }

    @GetMapping
    public String showMainForm(Model model){
        model.addAttribute("URLs", new URLs());
        return "index";
    }

    @PostMapping
    public String processURLs(@Valid URLs urls, Errors errors, Model model){
        if (errors.hasErrors()){
            return "index";
        }
        urlsService.saveURLs(urls);
        return "index";
    }
}
