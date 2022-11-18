package com.losquemonitosdechill.Backend.Tienda.cliente;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rfc;
    private String razon_social;
    private String regimen_fiscal;
    private String contacto;
    private String e_mail;
    private String e_mail2;
}
