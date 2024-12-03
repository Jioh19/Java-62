package com.edutecno.service;

import com.edutecno.dao.UsuarioDaoImpl;
import com.edutecno.model.Usuario;

public class UsuarioService {
	private static UsuarioDaoImpl usuarioDao;

	public UsuarioService() {
		super();
		usuarioDao = new UsuarioDaoImpl();
	}
	
	public void crearUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	
}
