package com.losquemonitosdechill.ventaCancelada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaCanceladaService {
    @Autowired
    private VentaCanceladaRepository canceladaRepository;

    public VentaCancelada create(VentaCancelada ventaCancelada){
        return canceladaRepository.save(ventaCancelada);
    }

    public List<VentaCancelada> getAll(){
        return canceladaRepository.findAll();
    }
    public void deleteById(Integer id){
        canceladaRepository.deleteById(id);
    }
    public Optional<VentaCancelada> getById(Integer id){
        return canceladaRepository.findById(id);
    }
}
