package com.losquemonitosdechill.Backend.cliente;

import com.losquemonitosdechill.Backend.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
