package com.manauara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manauara.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
