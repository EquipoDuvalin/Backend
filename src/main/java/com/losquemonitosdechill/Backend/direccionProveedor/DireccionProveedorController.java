package com.losquemonitosdechill.Backend.direccionProveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/direccion-proveedor")
public class DireccionProveedorController {

    @Autowired
    private DireccionProveedorService direccionProveedorService;

    @PostMapping(value = "/add")
    public ResponseEntity<DireccionProveedor> add(@RequestBody DireccionProveedor direccionProveedor) {
        DireccionProveedor newDireccionProveedor = direccionProveedorService.create(direccionProveedor);
        try {
            return ResponseEntity.created(new URI("/api/direccion-proveedor" + newDireccionProveedor.getId_proveedor())).body(direccionProveedor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<DireccionProveedor>> getAll() {
        return ResponseEntity.ok(direccionProveedorService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        direccionProveedorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DireccionProveedor>> getById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(direccionProveedorService.getById(id));
    }

}
