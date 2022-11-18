package com.losquemonitosdechill.Backend.Tienda.direccionProveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionProveedorService {

    @Autowired
    private DireccionProveedorRepository direccionProveedorRepository;

    public DireccionProveedor create(DireccionProveedor direccionProveedor) {
        return direccionProveedorRepository.save(direccionProveedor);
    }

    public List<DireccionProveedor> getAll() {
        return direccionProveedorRepository.findAll();
    }

    public void delete(Integer id) {
        direccionProveedorRepository.deleteById(id);
    }

    public Optional<DireccionProveedor> getById(Integer id) {
        return direccionProveedorRepository.findById(id);
    }
}
