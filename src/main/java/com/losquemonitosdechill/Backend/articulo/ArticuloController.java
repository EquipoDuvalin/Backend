package com.losquemonitosdechill.Backend.articulo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articulo")

public class ArticuloController {
  @Autowired
  private ArticuloService articuloServices;

  @PostMapping(value = "/add")
  public ResponseEntity<Articulo> save(@RequestBody Articulo articulo) {
    Articulo newArticulo = articuloServices.create(articulo);
    try {
      return ResponseEntity.created(new URI("/api/cliente" + newArticulo.getCod_asociado())).body(newArticulo);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping(value = "/list")
  public ResponseEntity<List<Articulo>> getAllArticulos() {
    return ResponseEntity.ok(articuloServices.getAllArticulos());
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") Integer id) {
    articuloServices.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<Articulo>> getArticuloById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(articuloServices.findById(id));
  }
}
