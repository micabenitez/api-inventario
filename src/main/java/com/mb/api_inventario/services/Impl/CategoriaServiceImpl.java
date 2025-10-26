package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.dtos.CategoriaDTO;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.exceptions.NotFoundException;
import com.mb.api_inventario.models.Categoria;
import com.mb.api_inventario.repositories.ICategoriaRepository;
import com.mb.api_inventario.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private final ICategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaCreada = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoriaCreada);
        return Response.builder()
                .status(201)
                .message("Categoria creada correctamente")
                .build();
    }

    @Override
    public Response actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));

        categoriaExistente.setNombre(categoriaDTO.getNombre());
        categoriaRepository.save(categoriaExistente);
        return Response.builder()
                .status(200)
                .message("Categoria actualizada correctamente")
                .build();
    }

    @Override
    public Response eliminarCategoria(Long id) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        categoriaRepository.deleteById(id);
        return Response.builder()
                .status(200)
                .message("Categoria eliminada correctamente")
                .build();
    }

    @Override
    public Response obtenerCategoriaPorId(Long id) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        CategoriaDTO categoriaDTO = modelMapper.map(categoriaExistente, CategoriaDTO.class);
        return Response.builder()
                .status(200)
                .categoriaDTO(categoriaDTO)
                .build();
    }

    @Override
    public Response listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaDTO> categoriaDTOS = modelMapper.map(categorias, new TypeToken(){}.getType());

        return Response.builder()
                .status(200)
                .categorias(categoriaDTOS)
                .build();
    }
}
