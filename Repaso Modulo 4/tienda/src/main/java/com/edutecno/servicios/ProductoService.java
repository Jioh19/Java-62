package com.edutecno.servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.edutecno.modelos.Categoria;
import com.edutecno.modelos.Producto;
import com.edutecno.modelos.Talla;
import com.edutecno.utils.Util;

public class ProductoService {
	private Map<String, Producto> productos;

	public ProductoService() {
		super();
		productos = new HashMap<>();
	}
	
	private Producto crearProducto() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese codigo");
		String codigo = sc.next();
		System.out.println("Ingrese nombre");
		
		//Ojo, este nextline esta para consumir el salto de linea que quedo en el buffer
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Ingrese categoria");
		String categoria = sc.next();
		System.out.println("Ingrese talla");
		String talla = sc.next();
		System.out.println("Ingrese precio");
		double precio = sc.nextDouble();
		System.out.println("Ingrese stock");
		int stock = sc.nextInt();
		Producto producto = new Producto(
				codigo, nombre, 
				Categoria.valueOf(categoria), 
				Talla.valueOf(talla), 
				precio, 
				stock);
		return producto;
		
	}
	
	public void agregarProducto() {
		Producto producto = crearProducto();
		productos.put(producto.getCodigo(), producto);
	}
	
	public void mostrarProductos() {
		
		for(String keys: productos.keySet()) {
			System.out.println(productos.get(keys));
		}
	}
	
	public void guardarProductos() {
		Util.save(productos, "productos.txt");
	}
	
	public void cargarProductos() {
		Util.loadProducto(productos, "productos.txt");
	}
	
	public Producto obtenerProducto(String id) {
		return productos.get(id);
	}
}
