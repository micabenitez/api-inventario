package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.dtos.ProductoDTO;
import com.mb.api_inventario.dtos.ProveedorDTO;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.exceptions.NotFoundException;
import com.mb.api_inventario.models.Categoria;
import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.models.Proveedor;
import com.mb.api_inventario.repositories.ICategoriaRepository;
import com.mb.api_inventario.repositories.IProductoRepository;
import com.mb.api_inventario.services.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private final IProductoRepository productoRepository;
    private final ICategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;


    @Override
    public Response crearProducto(ProductoDTO productoDTO) {
        Categoria categoria = categoriaRepository.findById(productoDTO.getCategoria().getId())
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        Producto productoCreado = modelMapper.map(productoDTO, Producto.class);
        System.out.println(productoCreado);
        productoRepository.save(productoCreado);
        return Response.builder()
                .status(201)
                .message("Producto creado correctamente")
                .build();
    }

    @Override
    public Response buscarProductoPorId(Long id) {
        return null;
    }

    @Override
    public Response actualizarProducto(Long id, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        Producto productoActualizado = modelMapper.map(productoDTO, Producto.class);
        productoRepository.save(productoActualizado);
        return Response.builder()
                .status(201)
                .message("Producto actualizado correctamente")
                .build();
    }

    @Override
    public Response eliminarProductoPorId(Long id) {
       Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        productoRepository.deleteById(id);
        return Response.builder()
                .status(201)
                .message("Producto eliminado correctamente")
                .build();
    }

    @Override
    public Response listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDTO> productosDTOList = modelMapper.map(productos, new TypeToken() {
        }.getType());

        return Response.builder()
                .status(200)
                .productos(productosDTOList)
                .build();
    }

    @Override
    public Response buscarPorNombre(String nombre) {
        return null;
    }
}
