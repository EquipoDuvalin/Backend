package com.losquemonitosdechill.Backend.Tienda.ventaCanceladaArticulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/venta-cancelada-articulo")
public class VentaCanceladaArticuloController {

    @Autowired
    private VentaCanceladaArticuloService ventaCanceladaArticuloServiceService;

    @PostMapping(value = "/add")
    public ResponseEntity<VentaCanceladaArticulo> save(@RequestBody VentaCanceladaArticulo ventaCanceladaArticulo) {
        VentaCanceladaArticulo newVentaCanceladaArticulo = ventaCanceladaArticuloServiceService.create(ventaCanceladaArticulo);
        try {
            return ResponseEntity.created(new URI("/api/venta-cancelada-articulo" + newVentaCanceladaArticulo.getId_pos())).body(newVentaCanceladaArticulo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<VentaCanceladaArticulo>> getAll() {
        return ResponseEntity.ok(ventaCanceladaArticuloServiceService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        ventaCanceladaArticuloServiceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<VentaCanceladaArticulo>> getById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(ventaCanceladaArticuloServiceService.findById(id));
    }
}
