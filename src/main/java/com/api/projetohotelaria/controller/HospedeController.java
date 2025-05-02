package com.api.projetohotelaria.controller;

import com.api.projetohotelaria.model.Hospede;
import com.api.projetohotelaria.service.HospedeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospedes")
public class HospedeController {
    
    @Autowired
    private HospedeService hospedeService;
    
    //Cria um novo hóspede
    @PostMapping("/adicionar")
    public String criarHospede(@ModelAttribute Hospede hospede) {
        hospedeService.salvarHospede(hospede);
        
        return "redirect:/hospedes";//VERIFICAR AQUIIII
    }
    
    //Listar todos os hóspedes
    @GetMapping
    public String listarHospedes(Model model) {
        List<Hospede> hospedes = hospedeService.listarHospedes();
        model.addAttribute("hospedes", hospedes);
        
        return "listaHospedes";
    }
    
    //Recupera hóspede pelo ID
    @GetMapping("/{id}")
    public String obterHospede(@PathVariable Integer id, Model model) {
        Hospede hospede = hospedeService.hospedeById(id);
        
        model.addAttribute("hospede", hospede);
        return "detalhesHospede";
    }
    
    //Atualizar os dados do hóspede
    @PutMapping("/atualizar/{id}")
    public String atualizarHospede(@PathVariable Integer id, @ModelAttribute Hospede hospede) {
        hospede.setId(id);
        hospedeService.atualizarHospede(id, hospede);
        
        return "redirect:/hospedes";
    }
    
    //Excluir hóspede
    @DeleteMapping("/excluir/{id}")
    public String excluirHospede(@PathVariable Integer id) {
        hospedeService.excluirHospede(id);
        
        return "redirect:/hospedes";
    }
}
