package com.losquemonitosdechill.Backend.proveedor;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class ProveedorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ProveedorService proveedorService;

  @Autowired
  private ObjectMapper objectMapper;

  private Proveedor proveedorOne = new Proveedor();
  private Proveedor proveedorTwo = new Proveedor();

  @Test
  void create() throws Exception {

    proveedorOne.setRfc("rucb0104");
    proveedorOne.setRazon_social("rucb010415");
    proveedorOne.setNombre_contacto("briseida");
    proveedorOne.setTel_principal("58913422");
    proveedorOne.setTel_movil("5561025921");
    proveedorOne.setE_mail("brissdelacruz@gmail.com");
    proveedorOne.setEstatus("activo");
    proveedorOne.setFecha_registro(Date.valueOf("2022-10-05"));

    ResultActions response = mockMvc.perform(post("/api/proveedor/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(proveedorOne)));

    response.andDo(print()).andExpect(status().isCreated())
        .andExpect(jsonPath("$.rfc", is(proveedorOne.getRfc())))

        .andExpect(jsonPath("$.razon_social", is(proveedorOne.getRazon_social())))
        .andExpect(jsonPath("$.nombre_contacto", is(proveedorOne.getNombre_contacto())))
        .andExpect(jsonPath("$.tel_principal", is(proveedorOne.getTel_principal())))
        .andExpect(jsonPath("$.tel_movil", is(proveedorOne.getTel_movil())))
        .andExpect(jsonPath("$.e_mail", is(proveedorOne.getE_mail())))
        .andExpect(jsonPath("$.estatus", is(proveedorOne.getEstatus())))
        .andExpect(jsonPath("$.fecha_registro", is(Date.valueOf("2022-10-04").toString())));
  }

  @Test
  void getAll() throws Exception {
    ResultActions response = mockMvc.perform(get("/api/proveedor/list"));
    response.andExpect(status().isOk())
        .andDo(print());

  }

  @Test
  void deleteById() throws Exception {
    // Setup
    proveedorTwo.setRfc("rucb0104");
    proveedorTwo.setRazon_social("rucb010415");
    proveedorTwo.setNombre_contacto("briseida");
    proveedorTwo.setTel_principal("58913422");
    proveedorTwo.setTel_movil("5561025921");
    proveedorTwo.setE_mail("brissdelacruz@gmail.com");
    proveedorTwo.setEstatus("activo");
    proveedorTwo.setFecha_registro(Date.valueOf("2022-10-05"));
    proveedorService.create(proveedorTwo);

    ResultActions response = mockMvc.perform(delete("/api/proveedor/delete/{id}", proveedorTwo.getId_proveedor()));
    response.andExpect(status().isOk());

  }

  @Test
  void getById() throws Exception {
    // Setup

    proveedorOne.setRfc("rucb0104");
    proveedorOne.setRazon_social("rucb010415");
    proveedorOne.setNombre_contacto("briseida");
    proveedorOne.setTel_principal("58913422");
    proveedorOne.setTel_movil("5561025921");
    proveedorOne.setE_mail("brissdelacruz@gmail.com");
    proveedorOne.setEstatus("activo");
    proveedorOne.setFecha_registro(Date.valueOf(LocalDate.now()));
    proveedorService.create(proveedorOne);

    ResultActions response = mockMvc.perform(get("/api/proveedor/{id}", proveedorOne.getId_proveedor()));

    response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.rfc", is(proveedorOne.getRfc())))
        .andExpect(jsonPath("$.razon_social", is(proveedorOne.getRazon_social())))
        .andExpect(jsonPath("$.nombre_contacto", is(proveedorOne.getNombre_contacto())))
        .andExpect(jsonPath("$.tel_principal", is(proveedorOne.getTel_principal())))
        .andExpect(jsonPath("$.tel_movil", is(proveedorOne.getTel_movil())))
        .andExpect(jsonPath("$.e_mail", is(proveedorOne.getE_mail())))
        .andExpect(jsonPath("$.estatus", is(proveedorOne.getEstatus())))
        .andExpect(jsonPath("$.fecha_registro", is(proveedorOne.getFecha_registro().toString())));

  }
}