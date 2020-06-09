package com.mourao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mourao.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
