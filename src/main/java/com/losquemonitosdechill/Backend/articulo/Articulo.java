package com.losquemonitosdechill.Backend.articulo;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "articulos")

public class Articulo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cod_barras;
  private Integer cod_asociado;
  private int id_clasificacion;
  private String cod_interno;
  private String cod_descripcion;
  private String descripcion_corta;
  private int cantidad_um;
  private String id_unidad;
  private String id_proveedor;
  private int precio_compra;
  private int utilidad;
  private int precio_venta;
  private String tipo_articulo;
  private int stock;
  private int stock_min;
  private int stock_max;
  private int iva;
  private Date kit_fecha_ini;
  private Date kit_fecha_fin;
  private Boolean articulo_disponible;
  private Boolean kit;
  private Date fecha_registro;
  private Boolean visible;
  private int puntos;
  private Date last_update_inventory;
  private String cve_producto;
}
