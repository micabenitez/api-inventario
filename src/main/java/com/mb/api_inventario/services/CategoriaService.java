package com.mb.api_inventario.services;

import com.mb.api_inventario.dtos.CategoriaDTO;
import com.mb.api_inventario.dtos.Response;

public interface CategoriaService {
    Response crearCategoria(CategoriaDTO categoriaDTO);
    Response actualizarCategoria(Long id, CategoriaDTO categoriaDTO);
    Response eliminarCategoria(Long id);
    Response obtenerCategoriaPorId(Long id);
    Response listarCategorias();
}
