package com.losquemonitosdechill.Backend.Tienda.articulo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ArticuloService {

  @Autowired
  private ArticuloRepository articuloRepository;

  public Articulo create(Articulo articulo) {
    return articuloRepository.save(articulo);
  }

  public List<Articulo> getAllArticulos() {
    return articuloRepository.findAll();
  }

  public void delete(Integer id) {
    articuloRepository.deleteById(id);
  }

  public Optional<Articulo> findById(Integer id) {
    return articuloRepository.findById(id);
  }
}
