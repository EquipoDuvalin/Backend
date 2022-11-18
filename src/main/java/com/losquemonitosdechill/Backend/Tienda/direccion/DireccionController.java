package com.losquemonitosdechill.Backend.Tienda.direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {
    @Autowired
    private DireccionService direccionServices;

    @PostMapping(value = "/add")
    public ResponseEntity<Direccion> save(@RequestBody Direccion direccion){
        Direccion newDireccion = direccionServices.create(direccion);
        try {
            return ResponseEntity.created(new URI("/api/direccion" + newDireccion.getId_direccion())).body(newDireccion);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Direccion>> getAll(){
        return ResponseEntity.ok(direccionServices.getAllDireccion());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        direccionServices.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Direccion>> getById(@PathVariable(value ="id") Integer id){
        return ResponseEntity.ok(direccionServices.getById(id));
    }
    
}
