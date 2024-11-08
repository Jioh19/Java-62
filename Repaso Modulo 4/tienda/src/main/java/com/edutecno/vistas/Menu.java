package com.edutecno.vistas;

import java.util.Scanner;

public class Menu extends MenuTemplate {

	private Scanner sc;
	
	
	public Menu() {
		super();
		sc = new Scanner(System.in);
	}

	@Override
	public void crearProducto() {
		System.out.println("Creando producto");

	}

	@Override
	public void crearCliente() {
		System.out.println("Creando cliente");

	}

	@Override
	public void crearVenta() {
		System.out.println("Creando Venta");

	}

	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarProductos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarClientes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarVentas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void iniciarMenu() {
		
		//while(true) {}
		//for(;true;) {}
		int eleccion;
		do {
			String menu = """
				****************************************
				* 1- Crear Producto                    *
				* 2- Crear Cliente                     *
				* 3- Crear Venta                       *
				* 4- Mostrar Producto                  *
				* 5- Mostrar Cliente                   *
				* 6- Mostrar Venta                     *
				* 7- Exportar Datos                    *
				* 8- Importar Datos                    *
				* 0- Salir                             *
				****************************************""";
			System.out.println(menu);
			eleccion = sc.nextInt();
			switch(eleccion) {
			case 1: 
				crearProducto();
				break;
			case 2:
				crearCliente();
				break;
			case 3: 
				crearVenta();
				break;
			case 4: 
				mostrarProductos();
				break;
			case 5:
				mostrarClientes();
				break;
			case 6: 
				mostrarVentas();
				break;
			case 7:
				exportarDatos();
				break;
			case 8: 
				importarDatos();
				break;
			case 0:
				System.out.println("Gracias por utilizar la app tienda");
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}
			
		} while(eleccion != 0);
	}

}
