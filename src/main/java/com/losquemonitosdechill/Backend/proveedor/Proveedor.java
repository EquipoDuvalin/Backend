package com.losquemonitosdechill.Backend.proveedor;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "proveedor")

public class Proveedor implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id_proveedor;
  private String rfc;
  private String razon_social;
  private String nombre_contacto;
  private String tel_principal;
  private String tel_movil;
  private String e_mail;
  private String estatus;
  private Date fecha_registro;
}
