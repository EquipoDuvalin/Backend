package com.losquemonitosdechill.Backend.Tienda.ventaCanceladaArticulo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "venta_cancelada_articulo")
public class VentaCanceladaArticulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pos;

    private String id_venta_cancel;
    private int no_articulo;
    private String cod_barras;
    private int cantidad;
    private boolean articulo_ofertado;
    private int precio_regular;
    private boolean cambio_precio;
    private int precio_vta;
    private int porcent_desc;
    private String user_name;
}
