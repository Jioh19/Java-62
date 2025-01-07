package com.edutecno.springSec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.springSec.model.Producto;
import com.edutecno.springSec.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository repository;

	public List<Producto> findAll() {
		return repository.findAll();
	}

	public void create(Producto producto) {
		repository.save(producto);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public void update(Producto producto) {
		repository.save(producto);
	}
}
