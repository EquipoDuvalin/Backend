package com.losquemonitosdechill.Backend.direccionProveedor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losquemonitosdechill.Backend.Tienda.direccionProveedor.DireccionProveedor;
import com.losquemonitosdechill.Backend.Tienda.direccionProveedor.DireccionProveedorService;
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
class DireccionProveedorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DireccionProveedorService direccionProveedorService;

    private DireccionProveedor direccionProveedorOne = new DireccionProveedor();
    private DireccionProveedor direccionProveedorTwo = new DireccionProveedor();

    @Test
    void add() throws Exception {
        direccionProveedorOne.setCalle("Arle");
        direccionProveedorOne.setNo_int("16");
        direccionProveedorOne.setNo_ext("4");
        direccionProveedorOne.setColonia("Santa Teresa II");
        direccionProveedorOne.setLocalidad("Santa Teresa");
        direccionProveedorOne.setId_entidad(1);
        direccionProveedorOne.setId_municipio(1);
        direccionProveedorOne.setPais("Mexico");
        direccionProveedorOne.setCod_postal("54690");

        ResultActions response = mockMvc.perform(post("/api/direccion-proveedor/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(direccionProveedorOne)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.calle", is(direccionProveedorOne.getCalle())))
                .andExpect(jsonPath("$.no_int", is(direccionProveedorOne.getNo_int())))
                .andExpect(jsonPath("$.no_ext", is(direccionProveedorOne.getNo_ext())))
                .andExpect(jsonPath("$.colonia", is(direccionProveedorOne.getColonia())))
                .andExpect(jsonPath("$.localidad", is(direccionProveedorOne.getLocalidad())))
                .andExpect(jsonPath("$.id_entidad", is(direccionProveedorOne.getId_entidad())))
                .andExpect(jsonPath("$.id_municipio", is(direccionProveedorOne.getId_municipio())))
                .andExpect(jsonPath("$.pais", is(direccionProveedorOne.getPais())))
                .andExpect(jsonPath("$.cod_postal", is(direccionProveedorOne.getCod_postal())));
    }

    @Test
    void getAll() throws Exception {
        ResultActions response = mockMvc.perform(get("/api/direccion-proveedor/list"));
        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteById() throws Exception {
        direccionProveedorTwo.setCalle("Onix");
        direccionProveedorTwo.setNo_int("14");
        direccionProveedorTwo.setNo_ext("1");
        direccionProveedorTwo.setColonia("Senderos");
        direccionProveedorTwo.setLocalidad("Pedregal");
        direccionProveedorTwo.setId_entidad(1);
        direccionProveedorTwo.setId_municipio(1);
        direccionProveedorTwo.setPais("Hidalgo");
        direccionProveedorTwo.setCod_postal("1234");
        direccionProveedorService.create(direccionProveedorTwo);

        ResultActions response = mockMvc.perform(delete("/api/direccion-proveedor/delete/{id}", direccionProveedorTwo.getId_proveedor()));
        response.andExpect(status().isOk());

    }

    @Test
    void getById() throws Exception {
        direccionProveedorOne.setCalle("Arle");
        direccionProveedorOne.setNo_int("16");
        direccionProveedorOne.setNo_ext("4");
        direccionProveedorOne.setColonia("Santa Teresa II");
        direccionProveedorOne.setLocalidad("Santa Teresa");
        direccionProveedorOne.setId_entidad(1);
        direccionProveedorOne.setId_municipio(1);
        direccionProveedorOne.setPais("Mexico");
        direccionProveedorOne.setCod_postal("54690");
        direccionProveedorService.create(direccionProveedorOne);

        ResultActions response = mockMvc.perform(get("/api/direccion-proveedor/{id}", direccionProveedorOne.getId_proveedor()));

        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.calle", is(direccionProveedorOne.getCalle())))
                .andExpect(jsonPath("$.no_int", is(direccionProveedorOne.getNo_int())))
                .andExpect(jsonPath("$.no_ext", is(direccionProveedorOne.getNo_ext())))
                .andExpect(jsonPath("$.colonia", is(direccionProveedorOne.getColonia())))
                .andExpect(jsonPath("$.localidad", is(direccionProveedorOne.getLocalidad())))
                .andExpect(jsonPath("$.id_entidad", is(direccionProveedorOne.getId_entidad())))
                .andExpect(jsonPath("$.id_municipio", is(direccionProveedorOne.getId_municipio())))
                .andExpect(jsonPath("$.pais", is(direccionProveedorOne.getPais())))
                .andExpect(jsonPath("$.cod_postal", is(direccionProveedorOne.getCod_postal())));
    }
}