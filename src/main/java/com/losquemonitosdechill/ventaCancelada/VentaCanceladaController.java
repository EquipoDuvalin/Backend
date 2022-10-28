package com.losquemonitosdechill.ventaCancelada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/ventaCancelada")
public class VentaCanceladaController {

    @Autowired
    private VentaCanceladaService canceladaService;

    @PostMapping(value = "/add")
    public ResponseEntity<VentaCancelada> add(@RequestBody VentaCancelada ventaCancelada){
        VentaCancelada newVenta = canceladaService.create(ventaCancelada);
        try {
            return ResponseEntity.created(new URI("/api/ventaCancelada" + newVenta.getId_pos())).body(newVenta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<VentaCancelada>> getAll() {
        return ResponseEntity.ok(canceladaService.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        canceladaService.deleteById(id);;
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<VentaCancelada>> getById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(canceladaService.getById(id));
    }
    
}
