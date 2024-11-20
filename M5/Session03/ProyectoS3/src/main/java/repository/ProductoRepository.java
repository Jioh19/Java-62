package repository;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoRepository {
	List<Producto> productos;

	public ProductoRepository() {
		super();
		productos = new ArrayList<>();
		productos.add(new Producto("001", "TV Sony 50", 1000, 20));
		productos.add(new Producto("002", "Playstation 5", 600, 40));
		productos.add(new Producto("003", "Notebook Gamer HP", 1600, 15));
	}
	
	public List<Producto> getAll() {
		return productos;
	}
	
	public Producto getById(String id) {
		return productos.stream().filter(prod -> prod.getId().equals(id)).findFirst().orElse(null);
	}
}
