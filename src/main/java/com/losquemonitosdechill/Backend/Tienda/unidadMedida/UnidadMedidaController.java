package com.losquemonitosdechill.Backend.Tienda.unidadMedida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/unidadMedida")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService medidaService;

    @PostMapping(value ="/add")
    public ResponseEntity<UnidadMedida> add(@RequestBody UnidadMedida unidadMedida){
        UnidadMedida newUnidadMedida = medidaService.create(unidadMedida);
        try {
            return ResponseEntity.created(new URI("/api/unidadMedida" + newUnidadMedida.getId_unidad())).body(newUnidadMedida);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UnidadMedida>> getAll() {
        return ResponseEntity.ok(medidaService.getAllUnidadMedida());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        medidaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<UnidadMedida>> getById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(medidaService.getById(id));
    }
    
}
