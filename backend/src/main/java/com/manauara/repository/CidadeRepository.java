package com.manauara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manauara.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    
}
