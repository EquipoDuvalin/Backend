package com.losquemonitosdechill.Backend.ventaArticulo;

import com.fasterxml.jackson.databind.ObjectMapper;

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

class VentaArticuloControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VentaArticuloService ventaService;

    @Autowired
    private ObjectMapper objectMapper;

    private VentaArticulo ventaOne = new VentaArticulo();
    private VentaArticulo ventaTwo = new VentaArticulo();

    @Test
    void add() throws Exception{
        // Setup
        ventaOne.setId_venta("12332");
        ventaOne.setNo_articulo(1);
        ventaOne.setCod_barras("u83874w839");
        ventaOne.setUser_code_bascula(12);
        ventaOne.setCantidad(1);
        ventaOne.setArticulo_ofertado(false);
        ventaOne.setPrecio_regular(123);
        ventaOne.setCambio_precio(false);
        ventaOne.setIva(0);
        ventaOne.setPrecio_venta(12);
        ventaOne.setPorcentaje_desc(0);
        ventaOne.setCant_devuelta(1);
        ventaOne.setUser_name("Mike");
        ventaOne.setId_promo("12");
        ventaOne.setNo_promo_aplicado(0);

        ResultActions response = mockMvc.perform(post("/api/ventaArticulo/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(ventaOne)));

        response.andDo(print()).
         andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_venta", is(ventaOne.getId_venta())))
                .andExpect(jsonPath("$.no_articulo", is(ventaOne.getNo_articulo())))
                .andExpect(jsonPath("$.cod_barras", is(ventaOne.getCod_barras())))
                .andExpect(jsonPath("$.user_code_bascula", is(ventaOne.getUser_code_bascula())))
                .andExpect(jsonPath("$.cantidad", is(ventaOne.getCantidad()))) 
                .andExpect(jsonPath("$.articulo_ofertado", is(ventaOne.isArticulo_ofertado()))) 
                .andExpect(jsonPath("$.precio_regular", is(ventaOne.getPrecio_regular())))
                .andExpect(jsonPath("$.cambio_precio", is(ventaOne.isCambio_precio())))
                .andExpect(jsonPath("$.iva", is(ventaOne.getIva())))
                .andExpect(jsonPath("$.precio_venta", is(ventaOne.getPrecio_venta())))
                .andExpect(jsonPath("$.porcentaje_desc", is(ventaOne.getPorcentaje_desc())))
                .andExpect(jsonPath("$.cant_devuelta", is(ventaOne.getCant_devuelta())))
                .andExpect(jsonPath("$.user_name", is(ventaOne.getUser_name())))
                .andExpect(jsonPath("$.id_promo", is(ventaOne.getId_promo())))
                .andExpect(jsonPath("$.no_promo_aplicado", is(ventaOne.getNo_promo_aplicado())));

    }

    @Test
    void getAll() throws Exception{
        ResultActions response = mockMvc.perform(get("/api/ventaArticulo/list"));
        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteById() throws Exception{
        // Setup
        ventaTwo.setId_venta("12332");
        ventaTwo.setNo_articulo(1);
        ventaTwo.setCod_barras("u83874w839");
        ventaTwo.setUser_code_bascula(12);
        ventaTwo.setCantidad(1);
        ventaTwo.setArticulo_ofertado(false);
        ventaTwo.setPrecio_regular(123);
        ventaTwo.setCambio_precio(false);
        ventaTwo.setIva(0);
        ventaTwo.setPrecio_venta(12);
        ventaTwo.setPorcentaje_desc(0);
        ventaTwo.setCant_devuelta(1);
        ventaTwo.setUser_name("Mike");
        ventaTwo.setId_promo("12");
        ventaTwo.setNo_promo_aplicado(0);
        ventaService.create(ventaTwo);

        ResultActions response = mockMvc.perform(delete("/api/ventaArticulo/delete/{id}", ventaTwo.getId_pos()));
        response.andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception{
        // Setup
        ventaOne.setId_venta("123");
        ventaOne.setNo_articulo(1);
        ventaOne.setCod_barras("u83874839");
        ventaOne.setUser_code_bascula(12);
        ventaOne.setCantidad(1);
        ventaOne.setArticulo_ofertado(false);
        ventaOne.setPrecio_regular(123);
        ventaOne.setCambio_precio(false);
        ventaOne.setIva(0);
        ventaOne.setPrecio_venta(12);
        ventaOne.setPorcentaje_desc(0);
        ventaOne.setCant_devuelta(1);
        ventaOne.setUser_name("Mike");
        ventaOne.setId_promo("12");
        ventaOne.setNo_promo_aplicado(0);
        ventaService.create(ventaOne);

        ResultActions response = mockMvc.perform(get("/api/ventaArticulo/{id}", ventaOne.getId_pos()));
        response.andDo(print()).
         andExpect(status().isOk())
                .andExpect(jsonPath("$.id_venta", is(ventaOne.getId_venta())))
                .andExpect(jsonPath("$.no_articulo", is(ventaOne.getNo_articulo())))
                .andExpect(jsonPath("$.cod_barras", is(ventaOne.getCod_barras())))
                .andExpect(jsonPath("$.user_code_bascula", is(ventaOne.getUser_code_bascula())))
                .andExpect(jsonPath("$.cantidad", is(ventaOne.getCantidad()))) 
                .andExpect(jsonPath("$.articulo_ofertado", is(ventaOne.isArticulo_ofertado()))) 
                .andExpect(jsonPath("$.precio_regular", is(ventaOne.getPrecio_regular())))
                .andExpect(jsonPath("$.cambio_precio", is(ventaOne.isCambio_precio())))
                .andExpect(jsonPath("$.iva", is(ventaOne.getIva())))
                .andExpect(jsonPath("$.precio_venta", is(ventaOne.getPrecio_venta())))
                .andExpect(jsonPath("$.porcentaje_desc", is(ventaOne.getPorcentaje_desc())))
                .andExpect(jsonPath("$.cant_devuelta", is(ventaOne.getCant_devuelta())))
                .andExpect(jsonPath("$.user_name", is(ventaOne.getUser_name())))
                .andExpect(jsonPath("$.id_promo", is(ventaOne.getId_promo())))
                .andExpect(jsonPath("$.no_promo_aplicado", is(ventaOne.getNo_promo_aplicado())));
    }

}
