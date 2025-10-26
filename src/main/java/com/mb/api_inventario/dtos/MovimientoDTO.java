package com.mb.api_inventario.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mb.api_inventario.enums.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovimientoDTO {
    private Long id;
    private LocalDateTime fecha;
    private int cantidadProductos;
    private double precioTotal;
    private int cantidad;
    private TipoMovimiento tipo;
    private ProductoDTO producto;
    private UsuarioDTO usuario;
}
