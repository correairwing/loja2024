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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manauara.entity.ProdutoImagens;
import com.manauara.service.ProdutoImagensService;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagemController {


    @Autowired
    private ProdutoImagensService service;

    @GetMapping("/")
    public List<ProdutoImagens> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("file") MultipartFile file, @RequestParam("idProduto") Long idProduto) {
        return service.inserir(idProduto, file);
    }

    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens obj) {
        return service.alterar(obj);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
