package com.edutecno.service;

import java.util.List;

import com.edutecno.dao.UsuarioDaoImpl;
import com.edutecno.model.Usuario;

public class LoginService {
	private static UsuarioDaoImpl usuarioDao;

	public LoginService() {
		super();
		usuarioDao = new UsuarioDaoImpl();
		usuarioDao.loadFromFiles();
	}
	
	public List<Usuario> mostrarUsuario() {
		return usuarioDao.getAll();
	}
	
	public boolean login(String username, String password) {
		Usuario usuario = usuarioDao.getByUsername(username);
		if(usuario == null) {
			return false;
		}
		if(usuario.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public void crearUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	
}
