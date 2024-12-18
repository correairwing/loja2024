package com.manauara.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manauara.entity.Pessoa;
import com.manauara.repository.PessoaRepository;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email) {
        
        Pessoa pessoa = repository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        repository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Código de recuperação de senha", "Olá, o seu código para recuperação de senha é o seguinte: " + pessoa.getCodigoRecuperacaoSenha());

        return "Código enviado!";
    }

    private String getCodigoRecuperacaoSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }

    public String alterarSenha(Pessoa pessoa) {
        Pessoa pessoaBanco = repository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
        
        if(pessoaBanco != null) {
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());
            if(diferenca.getTime()/1000<900){
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaBanco.setDataEnvioCodigo(null);
                repository.saveAndFlush(pessoaBanco);
                return "Senha alterada com sucesso";
            } else {
                return "Tempo expirado. Solicite um novo código";
            }
        } else {
            return "Email ou código não encontrado";
        }
    }
}
