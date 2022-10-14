package com.losquemonitosdechill.Backend.proveedor;

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
@RequestMapping(value = "/api/proveedor")
public class ProveedorController {

  @Autowired
  private ProveedorService proveedorService;

  @PostMapping(value = "/add")
  public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor) {
    Proveedor newProveedor = proveedorService.create(proveedor);
    try {
      return ResponseEntity.created(new URI("/api/proveedor" + newProveedor.getId_proveedor())).body(newProveedor);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping(value = "/list")
  public ResponseEntity<List<Proveedor>> getAllClients() {
    return ResponseEntity.ok(proveedorService.getAll());
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") Integer id) {
    proveedorService.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<Proveedor>> getById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(proveedorService.getById(id));
  }

}
