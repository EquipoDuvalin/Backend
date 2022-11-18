package com.losquemonitosdechill.Backend.Tienda.ventaArticulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventaArticulo")
public class VentaArticuloController {
    @Autowired
    private VentaArticuloService ventaArticuloService;

    @PostMapping(value = "/add")
    public ResponseEntity<VentaArticulo> save(@RequestBody VentaArticulo ventaArticulo){
        VentaArticulo newVentaArticulo = ventaArticuloService.create(ventaArticulo);
        try {
            return ResponseEntity.created(new URI("/api/ventaArticulo" + newVentaArticulo.getId_pos())).body(newVentaArticulo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<VentaArticulo>> getAll(){
        return ResponseEntity.ok(ventaArticuloService.getAllVentaArticulo());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        ventaArticuloService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<VentaArticulo>> getById(@PathVariable(value ="id") Integer id){
        return ResponseEntity.ok(ventaArticuloService.getById(id));
    }



}
