package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Permissao;
import com.manauara.repository.PermissaoRepository;

@Service
public class PermissaoService {


    @Autowired
    private PermissaoRepository repository;

    public List<Permissao> buscarTodos() {
        return repository.findAll();
    }

    public Permissao inserir(Permissao obj) {
        obj.setDataCriacao(new Date());
        Permissao newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public Permissao alterar(Permissao obj) {
        obj.setDataAtualizacao(new Date());
        Permissao newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        Permissao obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
