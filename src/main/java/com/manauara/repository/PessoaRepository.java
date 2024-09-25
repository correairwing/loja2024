package com.manauara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manauara.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
