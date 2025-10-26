package com.mb.api_inventario.services;

import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.dtos.UsuarioDTO;

public interface UsuarioService {
    Response obtenerUsuarioPorId(Long id);
    Response actualizarUsuario(Long id, UsuarioDTO usuarioDTO);

    Response eliminarUsuarioPorId(Long id);

    Response obtenerMovimientosDelUsuario(Long id);


    Response listarUsuarios();
}
