package com.mb.api_inventario.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mb.api_inventario.models.Movimiento;
import com.mb.api_inventario.models.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDTO {
    private Long idProducto;
    private String sku;
    private String nombre;
    private int stockActual;
    private int stockMinimo;
    private double precio;
    private CategoriaDTO categoria;
    private List<ProveedorDTO> proveedores;
    private List<MovimientoDTO> movimientos;
}


