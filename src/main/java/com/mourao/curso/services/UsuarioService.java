package com.mourao.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mourao.curso.entities.Usuario;
import com.mourao.curso.repositories.UserRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UserRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario user = repository.getOne(id);
		atualizaDados(user, usuario);
		return repository.save(user);
	}

	private void atualizaDados(Usuario user, Usuario usuario) {
		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		user.setTelefone(usuario.getTelefone());
	}
}
