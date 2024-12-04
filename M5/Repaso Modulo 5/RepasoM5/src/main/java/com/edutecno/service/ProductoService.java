package com.edutecno.service;

import com.edutecno.dao.ProductoDaoImpl;
import com.edutecno.model.Producto;

public class ProductoService {
	ProductoDaoImpl productoDao;

	public ProductoService() {
		super();
		productoDao = new ProductoDaoImpl();
	}
	
	public Producto obtenerPorId(int id) {
		return productoDao.getById(id);
	}
	
	public void guardarProducto(Producto producto) {
		productoDao.save(producto);
	}
	
	public void actualizarProducto(Producto producto) {
		productoDao.update(producto);
	}
	
	public void eliminarProducto(int id) {
		productoDao.delete(id);
	}
}
