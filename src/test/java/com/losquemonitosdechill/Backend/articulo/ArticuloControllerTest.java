package com.losquemonitosdechill.Backend.articulo;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class ArticuloControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ArticuloService articuloService;

  @Autowired
  private ObjectMapper objectMapper;

  private Articulo articuloOne = new Articulo();
  private Articulo articuloTwo = new Articulo();

  @Test
  void add() throws Exception {
    // setup
    articuloOne.setCod_asociado(1);
    articuloOne.setId_clasificacion(1);
    articuloOne.setCod_interno("12345as");
    articuloOne.setCod_descripcion("a2c3");
    articuloOne.setDescripcion_corta("descripcioncorta");
    articuloOne.setCantidad_um(1);
    articuloOne.setId_unidad("ac34");
    articuloOne.setId_proveedor("1cv2");
    articuloOne.setPrecio_compra(1);
    articuloOne.setUtilidad(1);
    articuloOne.setPrecio_venta(1);
    articuloOne.setUtilidad(1);
    articuloOne.setPrecio_venta(1);
    articuloOne.setTipo_articulo("a23c");
    articuloOne.setStock(1);
    articuloOne.setStock_min(1);
    articuloOne.setStock_max(1);
    articuloOne.setIva(1);
    articuloOne.setKit_fecha_ini(Date.valueOf("2022-10-05"));
    articuloOne.setKit_fecha_fin(Date.valueOf("2022-10-05"));
    articuloOne.setArticulo_disponible(null);
    articuloOne.setKit(null);
    articuloOne.setFecha_registro(Date.valueOf("2022-10-05"));
    articuloOne.setVisible(null);
    articuloOne.setPuntos(1);
    articuloOne.setLast_update_inventory(Date.valueOf("2022-10-05"));
    articuloOne.setCve_producto("ace4");

    ResultActions response = mockMvc.perform(post("/api/articulo/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(articuloOne)));

    response.andDo(print()).andExpect(status().isCreated())
            .andExpect(jsonPath("$.cod_asociado", is(articuloOne.getCod_asociado())))
        .andExpect(jsonPath("$.id_clasificacion", is(articuloOne.getId_clasificacion())))
        .andExpect(jsonPath("$.cod_interno", is(articuloOne.getCod_interno())))
        .andExpect(jsonPath("$.cod_descripcion", is(articuloOne.getCod_descripcion())))

        .andExpect(jsonPath("$.descripcion_corta", is(articuloOne.getDescripcion_corta())))
        .andExpect(jsonPath("$.cantidad_um", is(articuloOne.getCantidad_um())))
        .andExpect(jsonPath("$.id_unidad", is(articuloOne.getId_unidad())))
        .andExpect(jsonPath("$.id_proveedor", is(articuloOne.getId_proveedor())))
        .andExpect(jsonPath("$.precio_compra", is(articuloOne.getPrecio_compra())))
        .andExpect(jsonPath("$.utilidad", is(articuloOne.getUtilidad())))
        .andExpect(jsonPath("$.precio_venta", is(articuloOne.getPrecio_venta())))
        .andExpect(jsonPath("$.tipo_articulo", is(articuloOne.getTipo_articulo())))
        .andExpect(jsonPath("$.stock", is(articuloOne.getStock())))
        .andExpect(jsonPath("$.stock_min", is(articuloOne.getStock_min())))
        .andExpect(jsonPath("$.stock_max", is(articuloOne.getStock_max())))
        .andExpect(jsonPath("$.iva", is(articuloOne.getIva())))
        .andExpect(jsonPath("$.kit_fecha_ini", is(Date.valueOf("2022-10-04").toString())))
        .andExpect(jsonPath("$.kit_fecha_fin", is(Date.valueOf("2022-10-04").toString())))
        .andExpect(jsonPath("$.articulo_disponible", is(articuloOne.getArticulo_disponible())))
        .andExpect(jsonPath("$.kit", is(articuloOne.getKit())))
        .andExpect(jsonPath("$.fecha_registro", is(Date.valueOf("2022-10-04").toString())))
        .andExpect(jsonPath("$.visible", is(articuloOne.getVisible())))
        .andExpect(jsonPath("$.puntos", is(articuloOne.getPuntos())))
        .andExpect(jsonPath("$.last_update_inventory", is(Date.valueOf("2022-10-04").toString())))
        .andExpect(jsonPath("$.cve_producto", is(articuloOne.getCve_producto())));

  }

  @Test
  void getAllArticulos() throws Exception {

    ResultActions response = mockMvc.perform(get("/api/articulo/list"));
    response.andExpect(status().isOk())
        .andDo(print());
  }

  @Test
  void deleteArticulo() throws Exception {
    articuloTwo.setCod_asociado(2);
    articuloTwo.setId_clasificacion(1);
    articuloTwo.setCod_interno("12345as");
    articuloTwo.setCod_descripcion("a2c3");
    articuloTwo.setDescripcion_corta("descripcioncorta");
    articuloTwo.setCantidad_um(1);
    articuloTwo.setId_unidad("ac34");
    articuloTwo.setId_proveedor("1cv2");
    articuloTwo.setPrecio_compra(1);
    articuloTwo.setUtilidad(1);
    articuloTwo.setPrecio_venta(1);
    articuloTwo.setUtilidad(1);
    articuloTwo.setPrecio_venta(1);
    articuloTwo.setTipo_articulo("a23c");
    articuloTwo.setStock(1);
    articuloTwo.setStock_min(1);
    articuloTwo.setStock_max(1);
    articuloTwo.setIva(1);
    articuloTwo.setKit_fecha_ini(Date.valueOf("2022-10-05"));
    articuloTwo.setKit_fecha_fin(Date.valueOf("2022-10-05"));
    articuloTwo.setArticulo_disponible(null);
    articuloTwo.setKit(null);
    articuloTwo.setFecha_registro(Date.valueOf("2022-10-05"));
    articuloTwo.setVisible(null);
    articuloTwo.setPuntos(1);
    articuloTwo.setLast_update_inventory(Date.valueOf("2022-10-05"));
    articuloTwo.setCve_producto("ace4");
    articuloService.create(articuloTwo);

    ResultActions response = mockMvc
        .perform(delete("/api/articulo/delete/{id}", articuloTwo.getCod_asociado()));
    response.andExpect(status().isOk());

  }

  @Test
  void ArticuloById() throws Exception {
    // Setup
    articuloOne.setCod_asociado(1);
    articuloOne.setId_clasificacion(1);
    articuloOne.setCod_interno("12345as");
    articuloOne.setCod_descripcion("a2c3");
    articuloOne.setDescripcion_corta("descripcioncorta");
    articuloOne.setCantidad_um(1);
    articuloOne.setId_unidad("ac34");
    articuloOne.setId_proveedor("1cv2");
    articuloOne.setPrecio_compra(1);
    articuloOne.setUtilidad(1);
    articuloOne.setPrecio_venta(1);
    articuloOne.setUtilidad(1);
    articuloOne.setPrecio_venta(1);
    articuloOne.setTipo_articulo("a23c");
    articuloOne.setStock(1);
    articuloOne.setStock_min(1);
    articuloOne.setStock_max(1);
    articuloOne.setIva(1);
    articuloOne.setKit_fecha_ini(Date.valueOf(LocalDate.now()));
    articuloOne.setKit_fecha_fin(Date.valueOf(LocalDate.now()));
    articuloOne.setArticulo_disponible(null);
    articuloOne.setKit(null);
    articuloOne.setFecha_registro(Date.valueOf(LocalDate.now()));
    articuloOne.setVisible(null);
    articuloOne.setPuntos(1);
    articuloOne.setLast_update_inventory(Date.valueOf(LocalDate.now()));
    articuloOne.setCve_producto("ace4");
    articuloService.create(articuloOne);
    // when - action or the behaviour that we are going test
    ResultActions response = mockMvc.perform(get("/api/articulo/{id}", articuloOne.getCod_asociado()));

    // then - verify the output
    response.andExpect(status().isOk())
        .andDo(print())

        .andExpect(jsonPath("$.id_clasificacion", is(articuloOne.getId_clasificacion())))
        .andExpect(jsonPath("$.cod_interno", is(articuloOne.getCod_interno())))
        .andExpect(jsonPath("$.cod_descripcion", is(articuloOne.getCod_descripcion())))

        .andExpect(jsonPath("$.descripcion_corta", is(articuloOne.getDescripcion_corta())))
        .andExpect(jsonPath("$.cantidad_um", is(articuloOne.getCantidad_um())))
        .andExpect(jsonPath("$.id_unidad", is(articuloOne.getId_unidad())))
        .andExpect(jsonPath("$.id_proveedor", is(articuloOne.getId_proveedor())))
        .andExpect(jsonPath("$.precio_compra", is(articuloOne.getPrecio_compra())))
        .andExpect(jsonPath("$.utilidad", is(articuloOne.getUtilidad())))
        .andExpect(jsonPath("$.precio_venta", is(articuloOne.getPrecio_venta())))
        .andExpect(jsonPath("$.tipo_articulo", is(articuloOne.getTipo_articulo())))
        .andExpect(jsonPath("$.stock", is(articuloOne.getStock())))
        .andExpect(jsonPath("$.stock_min", is(articuloOne.getStock_min())))
        .andExpect(jsonPath("$.stock_max", is(articuloOne.getStock_max())))
        .andExpect(jsonPath("$.iva", is(articuloOne.getIva())))
        .andExpect(jsonPath("$.kit_fecha_ini", is(articuloOne.getKit_fecha_ini().toString())))
        .andExpect(jsonPath("$.kit_fecha_fin", is(articuloOne.getKit_fecha_fin().toString())))
        .andExpect(jsonPath("$.articulo_disponible", is(articuloOne.getArticulo_disponible())))
        .andExpect(jsonPath("$.kit", is(articuloOne.getKit())))
        .andExpect(jsonPath("$.fecha_registro", is(articuloOne.getFecha_registro().toString())))
        .andExpect(jsonPath("$.visible", is(articuloOne.getVisible())))
        .andExpect(jsonPath("$.puntos", is(articuloOne.getPuntos())))
        .andExpect(jsonPath("$.last_update_inventory", is(articuloOne.getLast_update_inventory().toString())))
        .andExpect(jsonPath("$.cve_producto", is(articuloOne.getCve_producto())));

  }
}
