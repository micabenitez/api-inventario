package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.dtos.MovimientoDTO;
import com.mb.api_inventario.dtos.MovimientoRequest;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.enums.TipoMovimiento;
import com.mb.api_inventario.exceptions.NameValueRequiredException;
import com.mb.api_inventario.exceptions.NotFoundException;
import com.mb.api_inventario.models.Movimiento;
import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.models.Proveedor;
import com.mb.api_inventario.repositories.IMovimientoRepository;
import com.mb.api_inventario.repositories.IProductoRepository;
import com.mb.api_inventario.repositories.IProveedorRepository;
import com.mb.api_inventario.services.MovimientoService;
import com.mb.api_inventario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private final IMovimientoRepository movimientoRepository;
    private final IProductoRepository productoRepository;
    private final IProveedorRepository proveedorRepository;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;


    @Override
    public Response registrarEntrada(MovimientoRequest movimientoRequest) {
        Long idProducto = movimientoRequest.getIdProducto();
        Long idProveedor = movimientoRequest.getIdProveedor();
        Integer cantidad = movimientoRequest.getCantidad();

        if(idProveedor == null) throw new NameValueRequiredException("El id del proveedor no puede ser nulo");

        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        Proveedor proveedor = proveedorRepository.findById(idProveedor).orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));

        // TODO: agregar auth
//        Usuario usuario = usuarioService.getCurrentUsuario();

        producto.setStockActual(producto.getStockActual() + cantidad);
        productoRepository.save(producto);

        Movimiento movimiento = Movimiento.builder()
                .tipo(TipoMovimiento.ENTRADA)
                .producto(producto)
                //.usuario()
                .cantidadProductos(cantidad)
                .precioTotal(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)))
                .build();

        movimientoRepository.save(movimiento);

        return Response.builder()
                .status(200)
                .message("Movimiento registrado correctamente")
                .build();
    }

    @Override
    public Response registrarSalida(MovimientoRequest movimientoRequest) {
        Long idProducto = movimientoRequest.getIdProducto();
        Long idProveedor = movimientoRequest.getIdProveedor();
        Integer cantidad = movimientoRequest.getCantidad();

        if(idProveedor == null) throw new NameValueRequiredException("El id del proveedor no puede ser nulo");

        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        Proveedor proveedor = proveedorRepository.findById(idProveedor).orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));

        // TODO: agregar auth
//        Usuario usuario = usuarioService.getCurrentUsuario();
        producto.setStockActual(producto.getStockActual() - cantidad);
        productoRepository.save(producto);

        Movimiento movimiento = Movimiento.builder()
                .tipo(TipoMovimiento.SALIDA)
                .producto(producto)
                //.usuario()
                .cantidadProductos(cantidad)
                .precioTotal(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)))
                .build();

        movimientoRepository.save(movimiento);
        return Response.builder()
                .status(200)
                .message("Movimiento registrado correctamente")
                .build();
    }

    @Override
    public Response obtenerMovimientos() {
        List<Movimiento> movimientoList = movimientoRepository.findAll();
        List<MovimientoDTO> movimientoDTOS = modelMapper.map(movimientoList, new TypeToken() {}.getType());

        return Response.builder()
                .status(200)
                .movimientos(movimientoDTOS)
                .build();
    }

    @Override
    public Response obtenerMovimientoPorId(Long id) {
        Movimiento movimientoExistente = movimientoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movimiento no encontrada"));
        MovimientoDTO movimientoDTODTO = modelMapper.map(movimientoExistente, MovimientoDTO.class);
        return Response.builder()
                .status(200)
                .movimientoDTO(movimientoDTODTO)
                .build();
    }

    @Override
    public Response obtenerMovimientosPorAnioYMes(Long id) {
        return null;
    }
}
