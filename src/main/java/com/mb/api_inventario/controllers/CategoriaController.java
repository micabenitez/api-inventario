package com.mb.api_inventario.controllers;

import com.mb.api_inventario.dtos.CategoriaDTO;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.dtos.UsuarioDTO;
import com.mb.api_inventario.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    @Autowired
    private final CategoriaService categoriaService;

    @GetMapping("/all")
    public ResponseEntity<Response> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtenerCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.obtenerCategoriaPorId(id));
    }

    @PostMapping()
    public ResponseEntity<Response> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(categoriaService.crearCategoria(categoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, categoriaDTO));
    }

    @DeleteMapping("/{id}")
    //TODO: SOLO ADMIN TIENE PERMISO A ESTE ENDPOINT
    public ResponseEntity<Response> eliminarCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.eliminarCategoria(id));
    }
}
