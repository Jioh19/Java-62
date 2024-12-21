package com.edutecno.springMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.springMVC.model.Usuario;
import com.edutecno.springMVC.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
}
