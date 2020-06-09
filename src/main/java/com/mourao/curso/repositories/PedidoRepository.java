package com.mourao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mourao.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
