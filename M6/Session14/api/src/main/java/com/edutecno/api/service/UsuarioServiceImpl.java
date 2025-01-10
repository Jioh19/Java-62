package com.edutecno.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.api.dao.UsuarioDao;
import com.edutecno.api.model.Usuario;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao dao;
	
	
	@Override
	public List<Usuario> listar() {
		log.info("Mostrando a todos los usuarios", dao.findAll());
		return dao.findAll();
	}

	@Override
	public void agregar(Usuario usuario) {
		dao.save(usuario);
		log.info("Creando un nuevo usuario: {}", usuario);
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
