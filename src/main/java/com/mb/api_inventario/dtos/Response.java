package com.mb.api_inventario.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mb.api_inventario.enums.RolUsuario;
import com.mb.api_inventario.models.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int status;
    private String message;
    private String token;
    private RolUsuario rolUsuario;

    private CategoriaDTO categoriaDTO;
    private List<CategoriaDTO> categorias;

    private ProductoDTO productoDTO;
    private List<ProductoDTO> productos;

    private ProveedorDTO proveedorDTO;
    private List<ProveedorDTO> proveedores;

    private MovimientoDTO movimientoDTO;
    private List<MovimientoDTO> movimientos;

    private UsuarioDTO usuarioDTO;
    private List<UsuarioDTO> usuarios;

}
