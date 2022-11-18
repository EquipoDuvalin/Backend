package com.losquemonitosdechill.Backend.Tienda.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public Venta create(Venta venta) {
        return ventaRepository.save(venta);
    }

    public List<Venta> getAll() {
        return ventaRepository.findAll();
    }

    public void deleteByid(Integer id) {
        ventaRepository.deleteById(id);
    }

    public Optional<Venta> getById(Integer id) {
        return ventaRepository.findById(id);
    }
}
