package com.losquemonitosdechill.Backend.cliente;

import com.losquemonitosdechill.Backend.cliente.Cliente;
import com.losquemonitosdechill.Backend.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClients() {
        return clienteRepository.findAll();
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }
}
