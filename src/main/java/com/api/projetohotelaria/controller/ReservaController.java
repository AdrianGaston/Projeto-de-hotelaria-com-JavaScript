package com.api.projetohotelaria.controller;

import com.api.projetohotelaria.model.Hospede;
import com.api.projetohotelaria.model.Quarto;
import com.api.projetohotelaria.model.Reserva;
import com.api.projetohotelaria.service.HospedeService;
import com.api.projetohotelaria.service.QuartoService;
import com.api.projetohotelaria.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private QuartoService quartoService;

    @Autowired
    private HospedeService hospedeService;
    
    //Mostra formulário para criar uma nova reserva
    @GetMapping("/nova")
    public String mostrarFormularioReserva(Model model) {
        List<Quarto> quartos = quartoService.listarQuartos();
        Reserva reserva = new Reserva();
        model.addAttribute("quartos", quartos);
        model.addAttribute("reserva", reserva);
        return "reservar";
    }
    
    //Criando nova reserva
    @PostMapping("/adicionar")
    public String criarReserva(
            @ModelAttribute Reserva reserva,
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("telefone") String telefone,
            @RequestParam("quarto") Integer quartoId,
            Model model) {
        
        //Recupera o Quarto do banco de dados usando o ID
        Quarto quarto = quartoService.quartoById(quartoId);
        reserva.setQuarto(quarto);//Adicionando o quarto na reserva
        
        //Criando novo objeto Hospede
        Hospede hospede = new Hospede();
        hospede.setNome(nome);
        hospede.setCpf(cpf);
        hospede.setTelefone(telefone);

        //Salva o Hospede no banco de dados
        hospede = hospedeService.salvarHospede(hospede);

        reserva.setHospede(hospede);//Adicionando o hospede na reserva

        //Calcula do total de dias e valor total da reserva
        int totalDias = reserva.calcularTotalDias();
        double valorTotal = reserva.calcularValorTotal();
        
        reserva.setTotalDias(totalDias);//Define o total de dias na reserva
        reserva.setValorTotal(valorTotal);//Define o valor total na reserva

        reserva = reservaService.salvarReserva(reserva);//Salvando a reserva no banco

        model.addAttribute("reserva", reserva);
        
        return "redirect:/reserva/" + reserva.getId();
    }
    
    //Mostra o formulário para editar uma reserva
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaService.reservaById(id);
        
        List<Quarto> quartos = quartoService.listarQuartos();
        
        model.addAttribute("reserva", reserva);
        model.addAttribute("quartos", quartos);
        return "reserva-editar";
    }
    
    //Atualiza a reserva
    @PostMapping("/editar/{id}")
    public String atualizarReserva(@PathVariable Integer id, @ModelAttribute Reserva reservaAtualizada) {
        //Recupera a reserva original
        Reserva reservaExistente = reservaService.reservaById(id);

        //Atualiza apenas os campos
        reservaExistente.setCheckin(reservaAtualizada.getCheckin());
        reservaExistente.setCheckout(reservaAtualizada.getCheckout());

        Quarto quarto = quartoService.quartoById(reservaAtualizada.getQuarto().getId());
        reservaExistente.setQuarto(quarto);

        //Atualiza total de dias e valor total
        reservaExistente.setTotalDias(reservaExistente.calcularTotalDias());
        reservaExistente.setValorTotal(reservaExistente.calcularValorTotal());

        reservaService.atualizarReserva(id, reservaExistente);

        return "redirect:/reserva/" + id;
    }
   
    //Listar todas as reservas
    @GetMapping
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
        return "reserva-informacao";
    }

    //Exclui uma reserva
    @GetMapping("/excluir/{id}")
    public String excluirReserva(@PathVariable Integer id) {
        reservaService.excluirReserva(id);
        
        return "redirect:/index";
    }
}
