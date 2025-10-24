package com.mb.api_inventario.models;

import com.mb.api_inventario.enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimiento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;
    private LocalDateTime fecha;
    private int cantidad;
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    @ManyToOne(targetEntity = Producto.class)
    private Producto producto;

    @ManyToOne(targetEntity = Usuario.class)
    private Usuario usuario;
}
