package com.manauara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manauara.dto.PessoaClienteRequestDTO;
import com.manauara.entity.Pessoa;
import com.manauara.service.PessoaClienteService;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService service;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO obj) {
        return service.registrar(obj);
    }
}
