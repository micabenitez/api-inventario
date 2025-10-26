package com.mb.api_inventario.services;

import com.mb.api_inventario.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto guardarProducto(Producto producto);

    Producto buscarProductoPorId(Long id);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProductoPorId(Long id);

    List<Producto> listarProductos();

    Producto buscarPorNombre(String nombre);

}