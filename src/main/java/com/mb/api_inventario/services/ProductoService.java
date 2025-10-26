package com.mb.api_inventario.services;

import com.mb.api_inventario.dtos.ProductoDTO;
import com.mb.api_inventario.dtos.Response;

import java.util.List;

public interface ProductoService {
    Response crearProducto(ProductoDTO producto);

    Response buscarProductoPorId(Long id);

    Response actualizarProducto(Long id, ProductoDTO producto);

    Response eliminarProductoPorId(Long id);

    Response listarProductos();

    Response buscarPorNombre(String nombre);

}