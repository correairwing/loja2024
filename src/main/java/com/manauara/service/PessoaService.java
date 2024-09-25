package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Pessoa;
import com.manauara.repository.PessoaRepository;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository repository;


    public List<Pessoa> buscarTodos() {
        return repository.findAll();
    }

    public Pessoa inserir(Pessoa obj) {
        obj.setDataCriacao(new Date());
        Pessoa newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Pessoa alterar(Pessoa obj) {
        obj.setDataAtualizacao(new Date());
        Pessoa newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        Pessoa obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
