package com.mourao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mourao.curso.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
