package com.manauara.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Permissao;
import com.manauara.entity.PermissaoPessoa;
import com.manauara.entity.Pessoa;
import com.manauara.repository.PermissaoPessoaRepository;
import com.manauara.repository.PermissaoRepository;

@Service
public class PermissaoPessoaService {


    @Autowired
    private PermissaoPessoaRepository repository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if(listaPermissao.size()>0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            repository.saveAndFlush(permissaoPessoa);
        }
    }
}
