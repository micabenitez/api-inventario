package com.mb.api_inventario.controllers;

import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepo;

    @CrossOrigin
    @GetMapping
    public List<Producto> getAllProductos() {
         return productoRepo.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Producto producto =  productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("El producto con ID" + id + "no existe."));
        return ResponseEntity.ok(producto);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto newProduct = productoRepo.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto requestProduct) {
        if(!productoRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        requestProduct.setId(id);
        Producto updatedProducto = productoRepo.save(requestProduct);
        return ResponseEntity.ok(updatedProducto);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        if(!productoRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        productoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
