package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.repositories.IProductoRepository;
import com.mb.api_inventario.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    IProductoRepository productoRepo;

    @Override
    public Producto guardarProducto(Producto producto) {
        return null;
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return null;
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        return null;
    }

    @Override
    public void eliminarProductoPorId(Long id) {

    }

    @Override
    public List<Producto> listarProductos() {
        return List.of();
    }

    @Override
    public Producto buscarPorNombre(String nombre) {
        return null;
    }
}
