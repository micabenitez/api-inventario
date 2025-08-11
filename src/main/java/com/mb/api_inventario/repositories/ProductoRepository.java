package com.mb.api_inventario.repositories;

import com.mb.api_inventario.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
