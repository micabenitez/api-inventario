package com.mb.api_inventario.controllers;

import com.mb.api_inventario.dtos.ProductoDTO;
import com.mb.api_inventario.dtos.Response;
import com.mb.api_inventario.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<Response> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtenerProducto(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarProductoPorId(id));
    }

    @PostMapping()
    public ResponseEntity<Response> crearProducto(@RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(productoService.crearProducto(productoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoDTO));
    }

    @DeleteMapping("/{id}")
    //TODO: SOLO ADMIN TIENE PERMISO A ESTE ENDPOINT
    public ResponseEntity<Response> eliminarCategoria(@PathVariable Long id){
        return ResponseEntity.ok(productoService.eliminarProductoPorId(id));
    }
}
