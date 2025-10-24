package com.mb.api_inventario.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String sku;
    private String nombre;
    @Column(name = "stock_actual")
    private int stockActual;
    @Column(name = "stock_minimo")
    private int stockMinimo;
    private double precio;

    @ManyToOne(targetEntity = Categoria.class)
    Categoria categoria;

    @ManyToMany(mappedBy = "productos")
    private List<Proveedor> proveedores;

    @OneToMany(targetEntity = Movimiento.class, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<Movimiento> movimientos;
}
