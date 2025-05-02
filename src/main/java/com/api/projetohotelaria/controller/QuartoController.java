package com.api.projetohotelaria.controller;

import com.api.projetohotelaria.model.Quarto;
import com.api.projetohotelaria.service.QuartoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quartos")
public class QuartoController {
    
    @Autowired
    private QuartoService quartoService;
    
    //Lista todos os quartos
    @GetMapping
    public String listarQuartos(Model model) {
        List<Quarto> quartos = quartoService.listarQuartos();
        
        model.addAttribute("quartos", quartos);
        return "listaQuartos";//MODIFICAR AQUI!!
    }
    
    //Recuperar quarto pelo ID
    @GetMapping("/{id}")
    public String obterQuarto(@PathVariable Integer id, Model model) {
        Quarto quarto = quartoService.quartoById(id);
        
        model.addAttribute("quarto", quarto);
        return "detalhesQuarto";//VER AQUI
    }
}
