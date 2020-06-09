package com.mourao.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mourao.curso.entities.Pedido;
import com.mourao.curso.entities.Usuario;
import com.mourao.curso.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> pedidos = service.findAll();
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido pedido = service.findById(id);
		return ResponseEntity.ok().body(pedido);
	}
}
