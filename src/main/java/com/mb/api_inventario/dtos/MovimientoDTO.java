package com.mb.api_inventario.dtos;

import com.mb.api_inventario.enums.TipoMovimiento;
import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.models.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;

public class MovimientoDTO {
    private Long id;
    private LocalDateTime fecha;
    private int cantidad;
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    private Producto producto;
    private Usuario usuario;
}
