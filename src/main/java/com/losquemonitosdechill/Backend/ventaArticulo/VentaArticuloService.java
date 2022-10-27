package com.losquemonitosdechill.Backend.ventaArticulo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaArticuloService {
    @Autowired
    private VentaArticuloRepository ventaArticuloRepository;

    public VentaArticulo create(VentaArticulo ventaArticulo){
        return ventaArticuloRepository.save(ventaArticulo);
    }

    public List<VentaArticulo> getAllVentaArticulo(){
        return ventaArticuloRepository.findAll();
    }
    public void deleteById(Integer id){
        ventaArticuloRepository.deleteById(id);
    }
    public Optional<VentaArticulo> getById(Integer id){
        return ventaArticuloRepository.findById(id);
    }
}
