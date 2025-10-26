package com.mb.api_inventario.controllers;

import com.mb.api_inventario.dtos.ProveedorDTO;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.services.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private final ProveedorService proveedorService;

    @GetMapping("/all")
    public ResponseEntity<Response> listarProveedores() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtenerProveedor(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorService.obtenerProveedorPorId(id));
    }

    @PostMapping()
    public ResponseEntity<Response> crearProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        return ResponseEntity.ok(proveedorService.crearProveedor(proveedorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) {
        return ResponseEntity.ok(proveedorService.actualizarProveedor(id, proveedorDTO));
    }

    @DeleteMapping("/{id}")
    //TODO: SOLO ADMIN TIENE PERMISO A ESTE ENDPOINT
    public ResponseEntity<Response> eliminarProveedor(@PathVariable Long id){
        return ResponseEntity.ok(proveedorService.eliminarProveedor(id));
    }
}
