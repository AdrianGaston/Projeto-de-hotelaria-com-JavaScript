package com.api.projetohotelaria.service;

import com.api.projetohotelaria.data.ReservaRepository;
import com.api.projetohotelaria.model.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    
    @Autowired
    ReservaRepository reservaRepository;
    
    //Salva a reserva
    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    
    //Lista a reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    } 
    
    //Busca a reserva pelo ID
    public Reserva reservaById(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }
    
    //Atualiza a reserva
    public Reserva atualizarReserva(Integer reservaId, Reserva reservaRequest) {
        Reserva reserva = reservaById(reservaId);
        
        reserva.setCheckin(reservaRequest.getCheckin());
        reserva.setCheckout(reservaRequest.getCheckout());
        reserva.getQuarto();
        reserva.setTotalDias(reservaRequest.getTotalDias());
        reserva.setValorTotal(reservaRequest.getValorTotal());
        
        return reservaRepository.save(reserva);
    }
    
    //Exclui a reserva
    public void excluirReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}
