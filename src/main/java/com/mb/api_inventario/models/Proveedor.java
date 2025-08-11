package com.mb.api_inventario.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
}
