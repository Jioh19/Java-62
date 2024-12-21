package com.edutecno.springMVC.service;

import java.util.List;
import java.util.Optional;

import com.edutecno.springMVC.model.Usuario;

public interface UsuarioService {
	List<Usuario> findAll();
	Optional<Usuario> findById(Long id);
	void save(Usuario usuario);
	void delete(Long id);
}
