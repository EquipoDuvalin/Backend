package com.losquemonitosdechill.Backend.direccion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losquemonitosdechill.Backend.Tienda.direccion.Direccion;
import com.losquemonitosdechill.Backend.Tienda.direccion.DireccionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
 class DireccionControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DireccionService direccionService;

    @Autowired
    private ObjectMapper objectMapper;

    private Direccion direccionOne = new Direccion();
    private Direccion direccionTwo = new Direccion();

    @Test
    void add() throws Exception{
        //setup
        direccionOne.setId_cliente("123");
        direccionOne.setId_municipio(1);
        direccionOne.setId_entidad(2);
        direccionOne.setCodigo_postal("1234");
        direccionOne.setColonia("Senderos");
        direccionOne.setCalle("Turquesa");
        direccionOne.setNo_exterior("21");
        direccionOne.setNo_interior("110");

        ResultActions response = mockMvc.perform(post("/api/direccion/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(direccionOne)));
        response.andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id_cliente", is(direccionOne.getId_cliente())))
        .andExpect(jsonPath("$.id_municipio", is(direccionOne.getId_municipio())))
        .andExpect(jsonPath("$.id_entidad", is(direccionOne.getId_entidad())))
        .andExpect(jsonPath("$.codigo_postal", is(direccionOne.getCodigo_postal())))
        .andExpect(jsonPath("$.colonia", is(direccionOne.getColonia())))
        .andExpect(jsonPath("$.calle", is(direccionOne.getCalle())))
        .andExpect(jsonPath("$.no_interior", is(direccionOne.getNo_interior())))
        .andExpect(jsonPath("$.no_exterior", is(direccionOne.getNo_exterior())));

    }

    @Test
    void  getAll() throws Exception{
        ResultActions response = mockMvc.perform(get("/api/direccion/list"));
        response.andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    void deleteById() throws Exception{
         //setup
         direccionTwo.setId_cliente("123");
         direccionTwo.setId_municipio(1);
         direccionTwo.setId_entidad(2);
         direccionTwo.setCodigo_postal("1234");
         direccionTwo.setColonia("Senderos");
         direccionTwo.setCalle("Turquesa");
         direccionTwo.setNo_exterior("21");
         direccionTwo.setNo_interior("110");
         direccionService.create(direccionTwo);

         ResultActions response = mockMvc.perform(delete("/api/direccion/delete/{id}", direccionTwo.getId_direccion()));
         response.andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception{
        //setup
        direccionOne.setId_cliente("123");
        direccionOne.setId_municipio(1);
        direccionOne.setId_entidad(2);
        direccionOne.setCodigo_postal("1234");
        direccionOne.setColonia("Senderos");
        direccionOne.setCalle("Turquesa");
        direccionOne.setNo_exterior("21");
        direccionOne.setNo_interior("110");
        direccionService.create(direccionOne);

        ResultActions response = mockMvc.perform(get("/api/direccion/{id}", direccionOne.getId_direccion()));

        response.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id_cliente", is(direccionOne.getId_cliente())))
        .andExpect(jsonPath("$.id_municipio", is(direccionOne.getId_municipio())))
        .andExpect(jsonPath("$.id_entidad", is(direccionOne.getId_entidad())))
        .andExpect(jsonPath("$.codigo_postal", is(direccionOne.getCodigo_postal())))
        .andExpect(jsonPath("$.colonia", is(direccionOne.getColonia())))
        .andExpect(jsonPath("$.calle", is(direccionOne.getCalle())))
        .andExpect(jsonPath("$.no_interior", is(direccionOne.getNo_interior())))
        .andExpect(jsonPath("$.no_exterior", is(direccionOne.getNo_exterior())));
    }

}
