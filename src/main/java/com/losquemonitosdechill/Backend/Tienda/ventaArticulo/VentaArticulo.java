package com.losquemonitosdechill.Backend.Tienda.ventaArticulo;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ventaArticulo")
public class VentaArticulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pos;
    private String id_venta;
    private int no_articulo;
    private String cod_barras;
    private int user_code_bascula;
    private int cantidad;
    private boolean articulo_ofertado;
    private int precio_regular;
    private boolean cambio_precio;
    private int iva;
    private int precio_venta;
    private int porcentaje_desc;
    private int cant_devuelta;
    private String user_name;
    private String id_promo;
    private int no_promo_aplicado;

}
