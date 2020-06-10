package com.mourao.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mourao.curso.entities.Usuario;
import com.mourao.curso.repositories.UserRepository;
import com.mourao.curso.services.exceptions.DataBaseException;
import com.mourao.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UserRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		try {
			Usuario user = repository.getOne(id);
			atualizaDados(user, usuario);
			return repository.save(user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualizaDados(Usuario user, Usuario usuario) {
		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		user.setTelefone(usuario.getTelefone());
	}
}
