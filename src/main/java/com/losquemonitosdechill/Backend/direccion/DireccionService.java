package com.losquemonitosdechill.Backend.direccion;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DireccionService {
    
    @Autowired
    private DireccionRespository direccionRespository;

    public Direccion create(Direccion direccion){
        return direccionRespository.save(direccion);
    }

    public List<Direccion> getAllDireccion(){
        return direccionRespository.findAll();
    }
    public void deleteById(Integer id){
        direccionRespository.deleteById(id);
    }
    public Optional<Direccion> getById(Integer id){
        return direccionRespository.findById(id);
    }

}
