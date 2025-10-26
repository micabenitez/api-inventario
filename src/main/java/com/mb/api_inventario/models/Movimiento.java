package com.mb.api_inventario.models;

import com.mb.api_inventario.enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;
    private final LocalDateTime fecha = LocalDateTime.now();
    @Column(name = "cant_productos")
    private int cantidadProductos;
    private BigDecimal precioTotal;
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    @ManyToOne(targetEntity = Producto.class)
    private Producto producto;

    @ManyToOne(targetEntity = Usuario.class)
    private Usuario usuario;
}
