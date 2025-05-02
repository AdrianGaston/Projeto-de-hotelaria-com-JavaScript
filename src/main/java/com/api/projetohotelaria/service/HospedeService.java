package com.api.projetohotelaria.service;

import com.api.projetohotelaria.data.HospedeRepository;
import com.api.projetohotelaria.model.Hospede;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospedeService {
    @Autowired
    HospedeRepository hospedeRepository;
    
    //Salva um hospede
    public Hospede salvarHospede(Hospede hospede) {
        
        return hospedeRepository.save(hospede);
    }
    
    //Listar todos os hóspedes
    public List<Hospede> listarHospedes() {
        return hospedeRepository.findAll();
    }
    
    //Busca um hóspede pelo ID
    public Hospede hospedeById(Integer id) {
        return hospedeRepository.findById(id).orElse(null);
    }
    
    public Hospede atualizarHospede(Integer hospedeId, Hospede hospedeRequest) {
        Hospede hospede = hospedeById(hospedeId);
        
        hospede.setNome(hospedeRequest.getNome());
        hospede.setTelefone(hospedeRequest.getTelefone());
        
        return hospedeRepository.save(hospede);
    }
    
    //Excluir um hóspede
    public void excluirHospede(Integer id) {
        hospedeRepository.deleteById(id);
    }
}
