package com.losquemonitosdechill.Backend.venta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losquemonitosdechill.Backend.Tienda.venta.Venta;
import com.losquemonitosdechill.Backend.Tienda.venta.VentaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.CoreMatchers.is;
import java.sql.Date;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class VentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Venta ventaOne = new Venta();
    private Venta ventaTwo = new Venta();

    @Test
    void add() throws Exception {
        // Setup
        ventaOne.setId_venta("1234");
        ventaOne.setVendedor("mrp4sten");
        ventaOne.setFolio(1);
        ventaOne.setFecha_venta(Date.valueOf("2022-10-05"));
        ventaOne.setTotal_vendido(10);
        ventaOne.setPago_efectivo(100);
        ventaOne.setPago_cheque(0);
        ventaOne.setPago_vales(0);
        ventaOne.setPago_tc(0);
        ventaOne.setSupervisor("mrp4sten");
        ventaOne.setUpload(false);
        ventaOne.setNum_registros(11);

        ResultActions response = mockMvc.perform(post("/api/venta/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ventaOne)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_venta", is(ventaOne.getId_venta())))
                .andExpect(jsonPath("$.vendedor", is(ventaOne.getVendedor())))
                .andExpect(jsonPath("$.folio", is(ventaOne.getFolio())))
                .andExpect(jsonPath("$.fecha_venta", is(Date.valueOf("2022-10-04").toString())))
                .andExpect(jsonPath("$.total_vendido", is(ventaOne.getTotal_vendido())))
                .andExpect(jsonPath("$.pago_efectivo", is(ventaOne.getPago_efectivo())))
                .andExpect(jsonPath("$.pago_cheque", is(ventaOne.getPago_cheque())))
                .andExpect(jsonPath("$.pago_vales", is(ventaOne.getPago_vales())))
                .andExpect(jsonPath("$.pago_tc", is(ventaOne.getPago_tc())))
                .andExpect(jsonPath("$.supervisor", is(ventaOne.getSupervisor())))
                .andExpect(jsonPath("$.upload", is(ventaOne.isUpload())))
                .andExpect(jsonPath("$.num_registros", is(ventaOne.getNum_registros())));
    }

    @Test
    void getAll() throws Exception{
        ResultActions response = mockMvc.perform(get("/api/venta/list"));
        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteById() throws Exception{
        // Setup
        ventaTwo.setId_venta("4321");
        ventaTwo.setVendedor("devorak");
        ventaTwo.setFolio(1);
        ventaTwo.setFecha_venta(Date.valueOf(LocalDate.now()));
        ventaTwo.setTotal_vendido(10);
        ventaTwo.setPago_efectivo(100);
        ventaTwo.setPago_cheque(0);
        ventaTwo.setPago_vales(0);
        ventaTwo.setPago_tc(0);
        ventaTwo.setSupervisor("qwerty");
        ventaTwo.setUpload(false);
        ventaTwo.setNum_registros(11);
        ventaService.create(ventaTwo);

        ResultActions response = mockMvc.perform(delete("/api/venta/delete/{id}", ventaTwo.getId_pos()));
        response.andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception{
        // Setup
        ventaOne.setId_venta("1234");
        ventaOne.setVendedor("qwerty");
        ventaOne.setFolio(1);
        ventaOne.setFecha_venta(Date.valueOf(LocalDate.now()));
        ventaOne.setTotal_vendido(10);
        ventaOne.setPago_efectivo(100);
        ventaOne.setPago_cheque(0);
        ventaOne.setPago_vales(0);
        ventaOne.setPago_tc(0);
        ventaOne.setSupervisor("devorak");
        ventaOne.setUpload(false);
        ventaOne.setNum_registros(11);
        ventaService.create(ventaOne);

        ResultActions response = mockMvc.perform(get("/api/venta/{id}", ventaOne.getId_pos()));

        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.id_venta", is(ventaOne.getId_venta())))
                .andExpect(jsonPath("$.vendedor", is(ventaOne.getVendedor())))
                .andExpect(jsonPath("$.folio", is(ventaOne.getFolio())))
                .andExpect(jsonPath("$.fecha_venta", is(ventaOne.getFecha_venta().toString())))
                .andExpect(jsonPath("$.total_vendido", is(ventaOne.getTotal_vendido())))
                .andExpect(jsonPath("$.pago_efectivo", is(ventaOne.getPago_efectivo())))
                .andExpect(jsonPath("$.pago_cheque", is(ventaOne.getPago_cheque())))
                .andExpect(jsonPath("$.pago_vales", is(ventaOne.getPago_vales())))
                .andExpect(jsonPath("$.pago_tc", is(ventaOne.getPago_tc())))
                .andExpect(jsonPath("$.supervisor", is(ventaOne.getSupervisor())))
                .andExpect(jsonPath("$.upload", is(ventaOne.isUpload())))
                .andExpect(jsonPath("$.num_registros", is(ventaOne.getNum_registros())));
    }
}