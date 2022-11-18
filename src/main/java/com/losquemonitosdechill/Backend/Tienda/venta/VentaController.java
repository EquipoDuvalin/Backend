package com.losquemonitosdechill.Backend.Tienda.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping(value = "/add")
    public ResponseEntity<Venta> add(@RequestBody Venta venta){
        Venta newVenta = ventaService.create(venta);
        try {
            return ResponseEntity.created(new URI("/api/venta" + newVenta.getId_pos())).body(newVenta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Venta>> getAll() {
        return ResponseEntity.ok(ventaService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        ventaService.deleteByid(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Venta>> getById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(ventaService.getById(id));
    }


}
