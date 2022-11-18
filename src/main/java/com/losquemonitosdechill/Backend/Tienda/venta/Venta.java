package com.losquemonitosdechill.Backend.Tienda.venta;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pos;
    private String  id_venta;
    private String vendedor;
    private int folio;
    private Date fecha_venta;
    private int total_vendido;
    private int pago_efectivo;
    private int pago_cheque;
    private int pago_vales;
    private int pago_tc;
    private String supervisor;
    private boolean upload;
    private int num_registros;
}
