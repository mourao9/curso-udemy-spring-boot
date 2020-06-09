package com.mourao.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mourao.curso.entities.Usuario;
import com.mourao.curso.services.UserService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
