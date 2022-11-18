package com.losquemonitosdechill.Backend.unidadMedida;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.losquemonitosdechill.Backend.Tienda.unidadMedida.UnidadMedida;
import com.losquemonitosdechill.Backend.Tienda.unidadMedida.UnidadMedidaService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.CoreMatchers.is;
import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UnidadMedidaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UnidadMedidaService medidaService;

    @Autowired
    private ObjectMapper objectMapper;

    private UnidadMedida uMedidaOne = new UnidadMedida();
    private UnidadMedida uMedidaTwo = new UnidadMedida();

    @Test
    void add() throws Exception{
         // Setup
        uMedidaOne.setDescripcion("Hola soy una descripcion");
        uMedidaOne.setFecha_registro(Date.valueOf("2022-10-05"));
        uMedidaOne.setCve_sat("26267fs");

        
        ResultActions response = mockMvc.perform(post("/api/unidadMedida/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(uMedidaOne)));

                response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.descripcion", is(uMedidaOne.getDescripcion())))
                .andExpect(jsonPath("$.fecha_registro", is(Date.valueOf("2022-10-04").toString())))
                .andExpect(jsonPath("$.cve_sat", is(uMedidaOne.getCve_sat())));
    }

    @Test
    void getAll() throws Exception{
        ResultActions response = mockMvc.perform(get("/api/unidadMedida/list"));
        response.andExpect(status().isOk())
                .andDo(print());
    }

}
