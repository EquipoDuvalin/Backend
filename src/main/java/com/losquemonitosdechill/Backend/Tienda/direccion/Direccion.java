package com.losquemonitosdechill.Backend.Tienda.direccion;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_direccion;
    private String id_cliente;
    private int id_municipio;
    private int id_entidad;
    private String codigo_postal;
    private String colonia;
    private String calle;
    private String no_interior;
    private String no_exterior;

}
