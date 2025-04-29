package com.api.projetohotelaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {
    
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }
    
    
    
    
    
}
