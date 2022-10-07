package com.losquemonitosdechill.Backend.proveedor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProveedorService {
  @Autowired
  private ProveedorRepository proveedorRepository;

  public Proveedor create(Proveedor proveedor) {
    return proveedorRepository.save(proveedor);
  }

  public List<Proveedor> getAll() {
    return proveedorRepository.findAll();
  }

  public void delete(Integer id) {
    proveedorRepository.deleteById(id);
  }

  public Optional<Proveedor> getById(Integer id) {
    return proveedorRepository.findById(id);
  }

}
