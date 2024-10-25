package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Categoria;
import com.manauara.repository.CategoriaRepository;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> buscarTodos() {
        return repository.findAll();
    }

    public Categoria inserir(Categoria obj) {
        obj.setDataCriacao(new Date());
        Categoria newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Categoria alterar(Categoria obj) {
        obj.setDataAtualizacao(new Date());
        Categoria newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        Categoria obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
