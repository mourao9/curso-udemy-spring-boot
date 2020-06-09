package com.mourao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mourao.curso.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	
}
