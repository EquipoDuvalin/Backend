package com.losquemonitosdechill.Backend.Tienda.direccionProveedor;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "direccion_proveedor")
public class DireccionProveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proveedor;
    private String calle;
    private String no_int;
    private String no_ext;
    private String colonia;
    private String localidad;
    private int id_entidad;
    private int id_municipio;
    private String pais;
    private String cod_postal;
}
