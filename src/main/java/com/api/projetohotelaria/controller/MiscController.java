package com.api.projetohotelaria.controller;

import com.api.projetohotelaria.model.Reserva;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {
    
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }
    
    @GetMapping("/reservar")
    public String paginaReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservar";
    }   
    
    @GetMapping("/reserva-informacao")
    public String informacaoReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        
        return "reserva-informacao";
    }
}
