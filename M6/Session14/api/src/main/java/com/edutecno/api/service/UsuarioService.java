package com.edutecno.api.service;

import java.util.List;

import com.edutecno.api.model.Usuario;

public interface UsuarioService {
	 List<Usuario> listar();
	 void agregar(Usuario usuario);
	 void eliminar(Integer id);
	 void modificar(Usuario usuario);
}
