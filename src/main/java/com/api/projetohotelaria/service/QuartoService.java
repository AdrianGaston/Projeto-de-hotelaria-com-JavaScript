package com.api.projetohotelaria.service;

import com.api.projetohotelaria.data.QuartoRepository;
import com.api.projetohotelaria.model.Quarto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;
    
    
    //Listar os quartos
    public List<Quarto> listarQuartos() {
        return quartoRepository.findAll();
    }
    
    //Busca quarto pelo ID
    public Quarto quartoById(Integer id) {
        return quartoRepository.findById(id).orElse(null);
    }
}
