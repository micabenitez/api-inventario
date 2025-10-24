package com.mb.api_inventario.repositories;

import com.mb.api_inventario.models.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {
}
