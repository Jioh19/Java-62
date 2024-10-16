package com.edutecno.menu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.edutecno.model.Producto;
import com.edutecno.servicio.ProductoServicio;

public class Menu {
	ProductoServicio servicio;
	List<Producto> carrito;
	private String menuInicial;
	
	
	
	public Menu() {
		super();
		menuInicial = """
				1- Ver lista de productos
				2- Agregar producto al carrito
				3- Pagar
				4- Salir
				""";
		servicio = new ProductoServicio();
		carrito = new LinkedList<>();
	}



	public void start() {
		int eleccion = 1;
		Scanner sc = new Scanner(System.in);
		servicio.getProductos();
		List<Producto> productos = servicio.getTodo();
		do {
			System.out.println(menuInicial);
			eleccion = sc.nextInt();
			switch(eleccion) {
			case 1:
				for(Producto producto: productos) {
					System.out.println(producto);	
				}
				break;
			
			case 2: 
				System.out.println("Ingrese el código del producto");
				String codigo = sc.next();
				Producto producto = servicio.getProducto(codigo);
				if(producto == null) {
					System.out.println("Producto no encontrado");
					break;
				}
				System.out.println("Desea agregar el producto " + producto.getNombre() + "?");
				String aceptar = sc.next();
				if(aceptar.equalsIgnoreCase("si")) {
					carrito.add(producto);
				}
				break;
			case 3: 
				System.out.println("Pagarás el total de: " + servicio.total(carrito));
				System.out.println("Generando Boleta");
				servicio.boleta(carrito);
				servicio.csv(carrito);
				break;
			}
		} while(eleccion != 4);
		
	
		
		System.out.println(carrito + "El total es de " + servicio.total(carrito));
		
	}
}
