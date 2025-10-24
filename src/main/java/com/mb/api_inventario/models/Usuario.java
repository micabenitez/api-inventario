package com.mb.api_inventario.models;

import com.mb.api_inventario.enums.RolUsuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @OneToMany(targetEntity = Movimiento.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Movimiento> movimientos;
}
