package com.api.projetohotelaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {
    
    @GetMapping("/index")
    public String homePage() {
        return "index";
    } 
    
    @GetMapping("/reserva-informacao")
    public String informacaoReserva(Model model) {
        return "reserva-informacao";
    }
}
