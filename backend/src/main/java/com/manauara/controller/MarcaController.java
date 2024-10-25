package com.manauara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manauara.entity.Marca;
import com.manauara.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping("/")
    public List<Marca> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca obj) {
        return service.inserir(obj);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca obj) {
        return service.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
     
}   
