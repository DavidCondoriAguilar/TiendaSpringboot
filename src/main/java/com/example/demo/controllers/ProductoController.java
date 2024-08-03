package com.example.demo.controllers;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.DTO.ProductoDTO;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Void> createProducto(@RequestBody ProductoDTO productoDTO) {
        productoService.createProducto(productoDTO);
        return ResponseEntity.status(201).build(); // 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable("id") Long id) {
        ProductoDTO producto = productoService.getProductoById(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProducto(@PathVariable("id") Long id, @RequestBody ProductoDTO productoDTO) {
        productoService.updateProducto(id, productoDTO);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("id") Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        List<CategoriaDTO> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }
}
