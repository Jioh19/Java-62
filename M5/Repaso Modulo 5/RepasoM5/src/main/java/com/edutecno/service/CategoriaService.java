package com.edutecno.service;

import java.util.List;

import com.edutecno.dao.CategoriaDaoImpl;
import com.edutecno.model.Categoria;

public class CategoriaService {
	CategoriaDaoImpl dao;

	public CategoriaService() {
		super();
		dao = new CategoriaDaoImpl();
	}
	
	public List<Categoria> obtenerCategorias() {
		return dao.getAll();
	}
	
	public Categoria obtenerCategoriaPorNombre(String nombre) {
		return dao.getByNombre(nombre);
	}
	
}
