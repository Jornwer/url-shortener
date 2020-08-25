package com.jornwer.urlshortener.web;

import com.jornwer.urlshortener.data.DataURL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String showMainForm(Model model){
        model.addAttribute("DataURL", new DataURL());
        return "index";
    }
}