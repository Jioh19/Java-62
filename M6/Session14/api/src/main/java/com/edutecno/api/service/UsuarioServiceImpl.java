package com.edutecno.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.api.dao.UsuarioDao;
import com.edutecno.api.model.Usuario;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao dao;
	
	
	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public void agregar(Usuario usuario) {
		dao.save(usuario);
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public void modificar(Usuario usuario) {
		dao.save(usuario);
	}

}
