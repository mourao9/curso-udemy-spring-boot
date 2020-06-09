package com.mourao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mourao.curso.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
