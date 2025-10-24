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
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;
    private String nombre;

    @OneToMany(targetEntity = Producto.class, fetch = FetchType.LAZY, mappedBy = "categoria")
    private List<Producto> productos;
}
