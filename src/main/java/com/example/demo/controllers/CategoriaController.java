package com.example.demo.controllers;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @PostMapping
    public void createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.createCategoria(categoriaDTO);
    }

    @GetMapping("/{id}")
    public CategoriaDTO getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PutMapping("/{id}")
    public void updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.updateCategoria(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
