package com.losquemonitosdechill.Backend.Tienda.ventaCanceladaArticulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaCanceladaArticuloService {

    @Autowired
    private VentaCanceladaArticuloRepository ventaCanceladaArticuloRepository;

    public VentaCanceladaArticulo create(VentaCanceladaArticulo ventaCanceladaArticulo) {
        return ventaCanceladaArticuloRepository.save(ventaCanceladaArticulo);
    }

    public List<VentaCanceladaArticulo> getAll() {
        return ventaCanceladaArticuloRepository.findAll();
    }

    public void delete(Integer id) {
        ventaCanceladaArticuloRepository.deleteById(id);
    }

    public Optional<VentaCanceladaArticulo> findById(Integer id) {
        return ventaCanceladaArticuloRepository.findById(id);
    }
}
