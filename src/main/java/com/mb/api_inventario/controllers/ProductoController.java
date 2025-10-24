package com.mb.api_inventario.controllers;

import com.mb.api_inventario.models.Producto;
import com.mb.api_inventario.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @CrossOrigin
    @GetMapping
    public List<Producto> getAllProductos() {
         return productoService.listarProductos();
    }
}
