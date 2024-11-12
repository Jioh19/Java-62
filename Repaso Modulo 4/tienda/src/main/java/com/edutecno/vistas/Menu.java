package com.edutecno.vistas;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InstanceAlreadyExistsException;

import com.edutecno.servicios.ClienteService;
import com.edutecno.servicios.ProductoService;
import com.edutecno.servicios.VentaService;

public class Menu extends MenuTemplate {

	private Scanner sc;
	private ProductoService productoService;
	private ClienteService clienteService;
	private VentaService ventaService;
	
	
	public Menu() {
		super();
		sc = new Scanner(System.in);
		productoService = new ProductoService();
		clienteService = new ClienteService();
		ventaService = new VentaService(productoService, clienteService);
	}

	@Override
	public void crearProducto() {
		System.out.println("Creando producto");
			try {
				productoService.agregarProducto();
			} catch (InstanceAlreadyExistsException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al Crear el producto");
			}
	}

	@Override
	public void crearCliente() {
        System.out.println("Creando cliente");
        clienteService.agregarCliente();
        

	}

	@Override
	public void crearVenta() {
		System.out.println("Creando Venta");
		ventaService.agregarVenta();

	}

	@Override
	public void exportarDatos() {
		productoService.guardarProductos();
		clienteService.guardarClientes();
		ventaService.guardarVentas();
	}

	@Override
	public void importarDatos() {
		productoService.cargarProductos();
		clienteService.cargarClientes();
		ventaService.cargarVentas();
	}

	@Override
	public void mostrarProductos() {
		productoService.mostrarProductos();

	}

	@Override
	public void mostrarClientes() {
		clienteService.mostrarCliente();

	}

	@Override
	public void mostrarVentas() {
		ventaService.mostrarVentas();

	}

	@Override
	public void iniciarMenu() {
		
		//while(true) {}
		//for(;true;) {}
		int eleccion;
		boolean continuar = true;
		do {
			try {
				
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
					continuar = false;
					break;
				default:
					System.out.println("Ingrese una opción válida");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Ingrese una elección válida");
				sc.next();
			}
			
		} while(continuar);
	}

}
