package com.mb.api_inventario.repositories;

import com.mb.api_inventario.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {
}
