package com.losquemonitosdechill.Backend.cliente;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest
class ClienteControllerTest {
    @MockBean
    private ClienteService clienteService;

    private Cliente cliente = new Cliente();

    @BeforeEach
    void setUp() {
        // Creating new Client
        cliente.setRfc("EJEMPLO1407");
        cliente.setRazon_social("EjemploRazonSocial");
        cliente.setRegimen_fiscal("EjemploRegimenFiscal");
        cliente.setContacto("EjemploContacto");
        cliente.setE_mail("ejemploEmail");
        cliente.setE_mail2("ejemploEmail2");
    }

    @SneakyThrows
    @Test
    public void save() {
        when(clienteService.create(any(Cliente.class))).thenReturn(cliente);
    }

    @Test
    public void getAllClients() {
        when(clienteService.getAllClients()).thenReturn(Arrays.asList(cliente));
    }

    @Test
    public void deleteClient() {
        doNothing().when(clienteService).delete(cliente.getId());
    }

    @Test
    public void getClientById() {
        when(clienteService.findById(cliente.getId())).thenReturn(Optional.of(cliente));
    }
}