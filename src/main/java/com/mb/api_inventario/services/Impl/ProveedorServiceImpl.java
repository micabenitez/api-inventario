package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.dtos.CategoriaDTO;
import com.mb.api_inventario.dtos.ProveedorDTO;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.exceptions.NotFoundException;
import com.mb.api_inventario.models.Proveedor;
import com.mb.api_inventario.repositories.IProveedorRepository;
import com.mb.api_inventario.services.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    private final IProveedorRepository proveedorRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response crearProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedorCreado = modelMapper.map(proveedorDTO, Proveedor.class);
        proveedorRepository.save(proveedorCreado);
        return Response.builder()
                .status(201)
                .message("Proveedor creado correctamente")
                .build();
    }

    // TODO
    @Override
    public Response actualizarProveedor(Long id, ProveedorDTO proveedorDTO) {
        Proveedor proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));

        return null;
    }

    @Override
    public Response eliminarProveedor(Long id) {
        Proveedor proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));
        proveedorRepository.deleteById(id);

        return Response.builder()
                .status(200)
                .message("Proveedor eliminado correctamente")
                .build();
    }

    @Override
    public Response obtenerProveedorPorId(Long id) {
        Proveedor proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));
        ProveedorDTO proveedorDTO = modelMapper.map(proveedorExistente, ProveedorDTO.class);
        return Response.builder()
                .status(200)
                .proveedorDTO(proveedorDTO)
                .build();
    }

    @Override
    public Response listarProveedores() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        List<ProveedorDTO> proveedorDTOList = modelMapper.map(proveedores, new TypeToken() {
        }.getType());

        return Response.builder()
                .status(200)
                .proveedores(proveedorDTOList)
                .build();
    }
}
