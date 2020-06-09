package com.mourao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mourao.curso.entities.ItensPedido;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
	
}
