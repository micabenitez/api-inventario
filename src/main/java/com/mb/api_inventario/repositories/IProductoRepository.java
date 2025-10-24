package com.mb.api_inventario.repositories;

import com.mb.api_inventario.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
    Producto findByNombre(String nombreProducto);
}
