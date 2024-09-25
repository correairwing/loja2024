package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Estado;
import com.manauara.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<Estado> buscarTodos() {
        return repository.findAll();
    }

    public Estado inserir(Estado obj) {
        obj.setDataCriacao(new Date());
        Estado newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Estado alterar(Estado obj) {
        obj.setDataAtualizacao(new Date());
        Estado newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        Estado obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
