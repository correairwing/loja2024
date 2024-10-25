package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Produto;
import com.manauara.repository.ProdutoRepository;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository repository;


    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

    public Produto inserir(Produto obj) {
        obj.setDataCriacao(new Date());
        Produto newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Produto alterar(Produto obj) {
        obj.setDataCriacao(new Date());
        Produto newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir (Long id) {
        Produto obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
