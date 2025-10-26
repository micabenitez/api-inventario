package com.mb.api_inventario.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private List<ProductoDTO> productos;
}
