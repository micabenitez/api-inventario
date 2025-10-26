package com.mb.api_inventario.services;

import com.mb.api_inventario.dtos.CategoriaDTO;
import com.mb.api_inventario.dtos.MovimientoRequest;
import com.mb.api_inventario.dtos.Response;

public interface MovimientoService {
    Response registrarEntrada(MovimientoRequest movimientoRequest);
    Response registrarSalida(MovimientoRequest movimientoRequest);
    Response obtenerMovimientos();
    Response obtenerMovimientoPorId(Long id);
    Response obtenerMovimientosPorAnioYMes(Long id);

}
