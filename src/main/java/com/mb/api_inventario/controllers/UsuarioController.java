package com.mb.api_inventario.controllers;

import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.dtos.UsuarioDTO;
import com.mb.api_inventario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    //TODO: agregar JWT y proteger endpoints con springSecurity

    @GetMapping("/all")
    public ResponseEntity<Response> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, usuarioDTO));
    }

    @DeleteMapping("/{id}")
    //TODO: SOLO ADMIN TIENE PERMISO A ESTE ENDPOINT
    public ResponseEntity<Response> eliminarUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.eliminarUsuarioPorId(id));
    }
}
