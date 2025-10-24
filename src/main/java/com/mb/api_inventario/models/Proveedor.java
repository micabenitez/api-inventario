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
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;

    @ManyToMany(targetEntity = Producto.class, fetch = FetchType.LAZY)
    @JoinTable(name = "proveedores_productos",
            joinColumns = @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor"),
            inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    )
    private List<Producto> productos;
}
