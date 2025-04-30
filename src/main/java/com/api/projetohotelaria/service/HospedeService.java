package com.api.projetohotelaria.service;

import com.api.projetohotelaria.data.HospedeRepository;
import com.api.projetohotelaria.model.Hospede;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospedeService {
    @Autowired
    HospedeRepository hospedeRepository;
    
    //Salvar um hóspede
   /* public Hospede salvar(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }*/
    public Hospede salvar(Hospede hospede) {
        
        return hospedeRepository.save(hospede);
    }
    
    //Listar todos os hóspedes
    public List<Hospede> listarTodos() {
        return hospedeRepository.findAll();
    }
    
    //Obter um hóspede pelo ID
    public Optional<Hospede> obterPorId(Integer id) {
        return hospedeRepository.findById(id);
    }
    
    //Atualizar um hóspede
    /*public Hospede atualizar(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }*/
    public Hospede atualizar(Integer hospedeId, Hospede hospedeRequest) {
        Hospede hospede = hospedeRepository.findById(hospedeId).orElse(null);
        
        hospede.setNome(hospedeRequest.getNome());
        hospede.setCpf(hospedeRequest.getCpf());
        hospede.setTelefone(hospedeRequest.getTelefone());
        
        hospedeRepository.save(hospede);
        return hospede;
    }
    
    //Excluir um hóspede
    public void excluir(Integer id) {
        hospedeRepository.deleteById(id);
    }
}
