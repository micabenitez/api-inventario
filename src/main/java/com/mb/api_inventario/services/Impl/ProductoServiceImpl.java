package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.repositories.IProductoRepository;
import com.mb.api_inventario.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    IProductoRepository productoRepo;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Optional<Producto> productoExistente = productoRepo.findById(id);
        if(productoExistente.isPresent()) {
            Producto p = productoExistente.get();

            Producto productoActualizado = new Producto();
            productoActualizado.setIdProducto(p.getIdProducto());
            productoActualizado.setPrecio(p.getPrecio());
            productoActualizado.setStockActual(p.getStockActual());
            productoActualizado.setNombre(p.getNombre());
            productoActualizado.setCategoria(p.getCategoria());
            productoActualizado.setStockMinimo(p.getStockMinimo());
            productoActualizado.setSku(p.getSku());
            productoActualizado.setMovimientos(p.getMovimientos());
            productoActualizado.setProveedores(p.getProveedores());

            return productoRepo.save(productoActualizado);
        }
        return null;
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto buscarPorNombre(String nombre) {
        return productoRepo.findByNombre(nombre);
    }
}
