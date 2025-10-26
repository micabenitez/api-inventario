package com.mb.api_inventario.services.Impl;

import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.dtos.UsuarioDTO;
import com.mb.api_inventario.exceptions.NotFoundException;
import com.mb.api_inventario.models.Usuario;
import com.mb.api_inventario.repositories.IUsuarioRepository;
import com.mb.api_inventario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private final IUsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response obtenerUsuarioPorId(Long id) {
        Usuario usuarioExistente =  usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con id"+ id +"no existe"));
        UsuarioDTO usuario = modelMapper.map(usuarioExistente, UsuarioDTO.class);

        return Response.builder()
                .status(200)
                .usuarioDTO(usuario)
                .build();
    }

    @Override
    public Response actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente =  usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con id"+ id +"no existe"));

        // TODO:  mapear UsuarioDTO con modelMapper
        if(usuarioDTO.getEmail() != null) usuarioExistente.setEmail(usuarioDTO.getEmail());

        return Response.builder()
                .status(200)
                .message("Usuario actualizado correctamente")
                .build();
    }

    @Override
    public Response eliminarUsuarioPorId(Long id) {
        Usuario usuarioExistente =  usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con id"+ id +"no existe"));

        usuarioRepository.deleteById(id);

        return Response.builder()
                .status(200)
                .message("Usuario eliminado correctamente")
                .build();
    }

    @Override
    public Response obtenerMovimientosDelUsuario(Long id) {
        Usuario usuarioExistente =  usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con id"+ id +"no existe"));

        //UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class)
        return null;
    }

    @Override
    public Response listarUsuarios() {
        return null;
    }
}
