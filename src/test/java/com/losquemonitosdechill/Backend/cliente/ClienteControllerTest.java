package com.losquemonitosdechill.Backend.cliente;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losquemonitosdechill.Backend.Tienda.cliente.Cliente;
import com.losquemonitosdechill.Backend.Tienda.cliente.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    private Cliente clienteOne = new Cliente();
    private Cliente clienteTwo = new Cliente();

    @Test
    void save() throws Exception {
        // setup
        clienteOne.setRfc("EJEMPLO1407");
        clienteOne.setRazon_social("EjemploRazonSocial");
        clienteOne.setRegimen_fiscal("EjemploRegimenFiscal");
        clienteOne.setContacto("EjemploContacto");
        clienteOne.setE_mail("ejemploEmail");
        clienteOne.setE_mail2("ejemploEmail2");

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/cliente/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clienteOne)));

        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.rfc",
                        is(clienteOne.getRfc())))
                .andExpect(jsonPath("$.razon_social",
                        is(clienteOne.getRazon_social())))
                .andExpect(jsonPath("$.regimen_fiscal",
                        is(clienteOne.getRegimen_fiscal())))
                .andExpect(jsonPath("$.contacto",
                        is(clienteOne.getContacto())))
                .andExpect(jsonPath("$.e_mail",
                        is(clienteOne.getE_mail())))
                .andExpect(jsonPath("$.e_mail2",
                        is(clienteOne.getE_mail2())));
    }

    @Test
    void getAllClients() throws Exception {
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/cliente/list"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteClient() throws Exception {
        // Setup
        clienteTwo.setRfc("EJEMPLO107");
        clienteTwo.setRazon_social("EjemploRazonSocial");
        clienteTwo.setRegimen_fiscal("EjemploRegimenFiscal");
        clienteTwo.setContacto("EjemploContacto");
        clienteTwo.setE_mail("ejemploEmail");
        clienteTwo.setE_mail2("ejemploEmail2");
        clienteService.create(clienteTwo);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/api/cliente/delete/{id}", clienteTwo.getId()));

        // then - verify the output
        response.andExpect(status().isOk());
    }

    @Test
    void getClientById() throws Exception {
        // Setup
        clienteOne.setRfc("EJEMPLO1407");
        clienteOne.setRazon_social("EjemploRazonSocial");
        clienteOne.setRegimen_fiscal("EjemploRegimenFiscal");
        clienteOne.setContacto("EjemploContacto");
        clienteOne.setE_mail("ejemploEmail");
        clienteOne.setE_mail2("ejemploEmail2");
        clienteService.create(clienteOne);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/cliente/{id}", clienteOne.getId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.rfc", is(clienteOne.getRfc())))
                .andExpect(jsonPath("$.razon_social", is(clienteOne.getRazon_social())))
                .andExpect(jsonPath("$.regimen_fiscal", is(clienteOne.getRegimen_fiscal())))
                .andExpect(jsonPath("$.contacto", is(clienteOne.getContacto())))
                .andExpect(jsonPath("$.e_mail", is(clienteOne.getE_mail())))
                .andExpect(jsonPath("$.e_mail2", is(clienteOne.getE_mail2())));
    }
}