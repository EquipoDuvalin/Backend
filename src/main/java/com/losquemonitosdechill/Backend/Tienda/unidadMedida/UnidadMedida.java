package com.losquemonitosdechill.Backend.Tienda.unidadMedida;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "unidadMedida")
public class UnidadMedida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_unidad;
    private String descripcion;
    private Date fecha_registro;
    private String cve_sat;
}
