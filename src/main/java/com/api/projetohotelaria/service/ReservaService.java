package com.api.projetohotelaria.service;

import com.api.projetohotelaria.data.ReservaRepository;
import com.api.projetohotelaria.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    
    @Autowired
    ReservaRepository reservaRepository;
    
    /*public Reserva encontrarPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }*/
    public Reserva buscarPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }
}
