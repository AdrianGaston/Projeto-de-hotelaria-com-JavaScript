package com.api.projetohotelaria.controller;

import com.api.projetohotelaria.model.Reserva;
import com.api.projetohotelaria.service.ReservaService;
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
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;
    
    //Slava umanova reserva
    @PostMapping("/adicionar")
    public String criarReserva(@ModelAttribute Reserva reserva) {
        reservaService.salvarReserva(reserva);
        
        return "/reserva-informacao";
    }
    
    //Listar todas as reservas
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaService.listarReservas();
        
        model.addAttribute("reservas", reservas);
        return "listarReservas";
    }
    
    //Recupera uma reserva pelo ID
    @GetMapping("/{id}")
    public String obterReserva(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaService.reservaById(id);
        
        model.addAttribute("reserva", reserva);
        return "detalhesReserva/id";
    }
    
    //Atualizar uma reserva
    @PutMapping
    public String atualizarReserva(@PathVariable Integer id, @ModelAttribute Reserva reserva) {
        reserva.setId(id);
        reservaService.atualizarReserva(id, reserva);
        
        return "redirect:/reservas";
    }
    
    //Exclui uma reserva
    @DeleteMapping("/excluir/{id}")
    public String excluirReserva(@PathVariable Integer id) {
        reservaService.excluirReserva(id);
        
        return "redirect:/reservas";
    }
    /*@GetMapping("/reserva")
    public String buscarReserva(Model model) {
        Reserva reserva = reservaService.buscarPorId(1);
        model.addAttribute("reserva", reserva);
        
        return "reserva-informacao";
    }
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
    }*/
    
}
