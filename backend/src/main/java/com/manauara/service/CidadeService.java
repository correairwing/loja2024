package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Cidade;
import com.manauara.repository.CidadeRepository;


@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> buscarTodos() {
        return repository.findAll();
    }

    public Cidade inserir(Cidade obj) {
        obj.setDataCriacao(new Date());
        Cidade newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Cidade alterar(Cidade obj) {
        obj.setDataAtualizacao(new Date());
        Cidade newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        Cidade obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
