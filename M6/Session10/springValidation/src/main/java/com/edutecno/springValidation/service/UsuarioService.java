package com.edutecno.springValidation.service;

import java.util.List;

import com.edutecno.springValidation.model.Usuario;

public interface UsuarioService {
	Usuario save(Usuario usario);
	List<Usuario> findAll();
}
