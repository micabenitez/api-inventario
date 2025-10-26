package com.mb.api_inventario.services;

import com.mb.api_inventario.dtos.ProveedorDTO;
import com.mb.api_inventario.dtos.Response;

public interface ProveedorService {
    Response crearProveedor(ProveedorDTO proveedorDTO);
    Response actualizarProveedor(Long id,ProveedorDTO proveedorDTO);
    Response eliminarProveedor(Long id);
    Response obtenerProveedorPorId(Long id);
    Response listarProveedores();
}
