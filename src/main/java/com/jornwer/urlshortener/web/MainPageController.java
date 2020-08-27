package com.jornwer.urlshortener.web;

import com.jornwer.urlshortener.data.URLs;
import com.jornwer.urlshortener.data.URLsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final URLsService urlsService;

    public MainPageController(URLsService urlsService){
        this.urlsService = urlsService;
    }

    @GetMapping("/")
    public String showMainForm(Model model){
        model.addAttribute("URLs", new URLs());
        return "index";
    }

    @PostMapping
    public String processURLs(@Valid URLs urls, Errors errors, Model model){
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
