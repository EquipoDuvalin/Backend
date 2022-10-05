package com.losquemonitosdechill.Backend.ventaCanceladaArticulo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class VentaCanceladaArticuloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VentaCanceladaArticuloService ventaCanceladaArticuloService;

    @Autowired
    private ObjectMapper objectMapper;

    private VentaCanceladaArticulo ventaCanceladaArticuloOne = new VentaCanceladaArticulo();
    private VentaCanceladaArticulo ventaCanceladaArticuloTwo = new VentaCanceladaArticulo();

    @Test
    void create() throws Exception {
        // Setup
        ventaCanceladaArticuloOne.setId_venta_cancel("1234");
        ventaCanceladaArticuloOne.setNo_articulo(1);
        ventaCanceladaArticuloOne.setCod_barras("1234");
        ventaCanceladaArticuloOne.setCantidad(1);
        ventaCanceladaArticuloOne.setArticulo_ofertado(false);
        ventaCanceladaArticuloOne.setPrecio_regular(10);
        ventaCanceladaArticuloOne.setCambio_precio(false);
        ventaCanceladaArticuloOne.setPrecio_vta(11);
        ventaCanceladaArticuloOne.setPorcent_desc(0);
        ventaCanceladaArticuloOne.setUser_name("user-name");

        ResultActions response = mockMvc.perform(post("/api/venta-cancelada-articulo/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ventaCanceladaArticuloOne)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_venta_cancel",
                        is(ventaCanceladaArticuloOne.getId_venta_cancel())))
                .andExpect(jsonPath("$.no_articulo",
                        is(ventaCanceladaArticuloOne.getNo_articulo())))
                .andExpect(jsonPath("$.cod_barras",
                        is(ventaCanceladaArticuloOne.getCod_barras())))
                .andExpect(jsonPath("$.cantidad",
                        is(ventaCanceladaArticuloOne.getCantidad())))
                .andExpect(jsonPath("$.articulo_ofertado",
                        is(ventaCanceladaArticuloOne.isArticulo_ofertado())))
                .andExpect(jsonPath("$.precio_regular",
                        is(ventaCanceladaArticuloOne.getPrecio_regular())))
                .andExpect(jsonPath("$.cambio_precio",
                        is(ventaCanceladaArticuloOne.isCambio_precio())))
                .andExpect(jsonPath("$.precio_vta",
                        is(ventaCanceladaArticuloOne.getPrecio_vta())))
                .andExpect(jsonPath("$.porcent_desc",
                        is(ventaCanceladaArticuloOne.getPorcent_desc())))
                .andExpect(jsonPath("$.user_name",
                        is(ventaCanceladaArticuloOne.getUser_name())));
    }

    @Test
    void getAll() throws Exception {
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/venta-cancelada-articulo/list"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteById() throws Exception {
        // Setup
        ventaCanceladaArticuloTwo.setId_venta_cancel("5432");
        ventaCanceladaArticuloTwo.setNo_articulo(2);
        ventaCanceladaArticuloTwo.setCod_barras("4321");
        ventaCanceladaArticuloTwo.setCantidad(2);
        ventaCanceladaArticuloTwo.setArticulo_ofertado(false);
        ventaCanceladaArticuloTwo.setPrecio_regular(11);
        ventaCanceladaArticuloTwo.setCambio_precio(false);
        ventaCanceladaArticuloTwo.setPrecio_vta(12);
        ventaCanceladaArticuloTwo.setPorcent_desc(0);
        ventaCanceladaArticuloTwo.setUser_name("user-name");
        ventaCanceladaArticuloService.create(ventaCanceladaArticuloTwo);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/api/venta-cancelada-articulo/delete/{id}", ventaCanceladaArticuloTwo.getId_pos()));

        // then - verify the output
        response.andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        // Setup
        ventaCanceladaArticuloTwo.setId_venta_cancel("67882");
        ventaCanceladaArticuloOne.setNo_articulo(1);
        ventaCanceladaArticuloOne.setCod_barras("1234");
        ventaCanceladaArticuloOne.setCantidad(1);
        ventaCanceladaArticuloOne.setArticulo_ofertado(false);
        ventaCanceladaArticuloOne.setPrecio_regular(10);
        ventaCanceladaArticuloOne.setCambio_precio(false);
        ventaCanceladaArticuloOne.setPrecio_vta(11);
        ventaCanceladaArticuloOne.setPorcent_desc(0);
        ventaCanceladaArticuloOne.setUser_name("user-name");
        ventaCanceladaArticuloService.create(ventaCanceladaArticuloOne);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/venta-cancelada-articulo/{id}", ventaCanceladaArticuloOne.getId_pos()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id_venta_cancel", is(ventaCanceladaArticuloOne.getId_venta_cancel())))
                .andExpect(jsonPath("$.no_articulo", is(ventaCanceladaArticuloOne.getNo_articulo())))
                .andExpect(jsonPath("$.cod_barras", is(ventaCanceladaArticuloOne.getCod_barras())))
                .andExpect(jsonPath("$.cantidad", is(ventaCanceladaArticuloOne.getCantidad())))
                .andExpect(jsonPath("$.articulo_ofertado", is(ventaCanceladaArticuloOne.isArticulo_ofertado())))
                .andExpect(jsonPath("$.precio_regular", is(ventaCanceladaArticuloOne.getPrecio_regular())))
                .andExpect(jsonPath("$.cambio_precio", is(ventaCanceladaArticuloOne.isCambio_precio())))
                .andExpect(jsonPath("$.precio_vta", is(ventaCanceladaArticuloOne.getPrecio_vta())))
                .andExpect(jsonPath("$.porcent_desc", is(ventaCanceladaArticuloOne.getPorcent_desc())))
                .andExpect(jsonPath("$.user_name", is(ventaCanceladaArticuloOne.getUser_name())));
    }
}