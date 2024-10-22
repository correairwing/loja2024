package com.manauara.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.dto.PessoaClienteRequestDTO;
import com.manauara.entity.Pessoa;
import com.manauara.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private PessoaClienteRepository repository;

    @Autowired
    private EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDTO obj) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(obj);

        pessoa.setDataCriacao(new Date());
        Pessoa newObj = repository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(newObj);
        emailService.enviarEmailTexto(newObj.getEmail(), "Cadastro na Loja Tabajara", "O registro na loja foi realizado com sucesso. Em breve voce receberá a senha de acesso");
        return newObj;
    }
}
