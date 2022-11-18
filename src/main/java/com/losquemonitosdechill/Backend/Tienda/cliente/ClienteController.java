package com.losquemonitosdechill.Backend.Tienda.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/add")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.create(cliente);
        try {
            return ResponseEntity.created(new URI("/api/cliente" + newCliente.getId())).body(newCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Cliente>> getAllClients() {
        return ResponseEntity.ok(clienteService.getAllClients());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") Integer id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public   ResponseEntity<Optional<Cliente>> getClientById(@PathVariable ("id") Integer id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }
}
