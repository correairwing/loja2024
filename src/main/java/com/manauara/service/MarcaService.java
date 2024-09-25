package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Marca;
import com.manauara.repository.MarcaRepository;


@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public List<Marca> buscarTodos() {
        return repository.findAll();
    }

    public Marca inserir(Marca obj) {
        obj.setDataCriacao(new Date());
        Marca newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Marca alterar(Marca obj) {
        obj.setDataAtualizacao(new Date());
        Marca newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        Marca obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
