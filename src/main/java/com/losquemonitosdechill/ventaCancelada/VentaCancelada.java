package com.losquemonitosdechill.ventaCancelada;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "ventaCancelada")
public class VentaCancelada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pos;
    private String id_venta_cancel;
    private String vendedor;
    private Date fecha;
    private int total_vendido;
    private int pago_efectivo;
    private int pago_cheque;
    private int pago_vales;
    private int pago_tc;
    private String status;
    private String supervisor;
    private boolean upload;

    
}