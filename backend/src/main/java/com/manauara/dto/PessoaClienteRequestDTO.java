package com.manauara.dto;

import org.springframework.beans.BeanUtils;

import com.manauara.entity.Cidade;
import com.manauara.entity.Pessoa;

import lombok.Data;

@Data
public class PessoaClienteRequestDTO {

    private String nome;

    private String cpf;

    private String email;

    private String endereco;

    private String cep;

    private Cidade cidade;

    public Pessoa converter(PessoaClienteRequestDTO clienteRequestDTO) {
        Pessoa pesssoa = new Pessoa();

        BeanUtils.copyProperties(clienteRequestDTO, pesssoa);
        return pesssoa;
    }
}
