package com.api.projetohotelaria.controller;

import com.api.projetohotelaria.data.ReservaRepository;
import com.api.projetohotelaria.model.Reserva;
import com.api.projetohotelaria.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    ReservaService reservaService;
    @Autowired
    ReservaRepository reservaRepository;
    /*@GetMapping("/{id}")
    public String obterReserva(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaService.buscarPorId(id);
        
        model.addAttribute("reserva", reserva);
        return "reserva-informacao"; 
    }*/
    /*@GetMapping("/reserva")
    public String buscarReserva(Model model) {
        Reserva reserva = reservaService.buscarPorId(1);
        model.addAttribute("reserva", reserva);
        
        return "reserva-informacao";
    }*/
    @GetMapping("/reserva-informacao")
    public String reservaInformacao(Model model) {
        Reserva reserva = reservaRepository.findById(1).orElse(null);
        reserva.getQuarto().getTipo();
        reserva.getHospede().getNome();
        reserva.getTotalDias();
        reserva.getValorTotal();
        
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
        } else {
            model.addAttribute("reserva", new Reserva());
        }
        return "reserva-informacao";
    }
    
}
