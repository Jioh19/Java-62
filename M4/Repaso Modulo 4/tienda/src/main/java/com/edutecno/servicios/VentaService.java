package com.edutecno.servicios;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.edutecno.modelos.Cliente;
import com.edutecno.modelos.Producto;
import com.edutecno.modelos.Venta;
import com.edutecno.utils.Util;

public class VentaService {
	private Map<String, Venta> ventas;
	private Scanner sc;
	private ProductoService productoService;
	private ClienteService clienteService;

	public VentaService(ProductoService productoService, ClienteService clienteService) {
		super();
		sc  = new Scanner(System.in);
		ventas = new HashMap<>();
		this.productoService = productoService;
		this.clienteService = clienteService;
	}
	
	private Venta crearVenta() {
		
		System.out.println("Ingrese id");
		String id = sc.next();
		System.out.println("Ingrese fecha");
		LocalDate fecha = LocalDate.parse(sc.next());
		clienteService.mostrarCliente();
		System.out.println("Ingrese Id de cliente");
		String idCliente = sc.next();
		
		Cliente cliente = clienteService.obtenerCliente(idCliente);
		System.out.println("Ingrese productos");
		Map<Producto, Integer> ventas = new HashMap<>();
		ingresarProductos(ventas);
		System.out.println("Ingrese descuento");
		double descuento = sc.nextDouble();
		Venta venta = new Venta(
				id, fecha, cliente, ventas, descuento);
		return venta;
	}
	
	public void agregarVenta() {
		Venta venta = crearVenta();
		ventas.put(venta.getId(), venta);
	}
	
	public void mostrarVentas() {
		for(String keys: ventas.keySet()) {
			System.out.println(ventas.get(keys));
		}
	}
	
	public void guardarVentas() {
		Util.save(ventas, "ventas.txt");
	}
	
	private void ingresarProductos(Map<Producto, Integer> ventas) {
		int continuar;
		do {
			productoService.mostrarProductos();
			System.out.println("Ingrese Id del producto");
			String id = sc.next();
			System.out.println("Ingrese cantidad del producto");
			Integer cantidad = sc.nextInt();
			Producto producto = productoService.obtenerProducto(id);
			System.out.println(producto);
			ventas.put(producto, cantidad);
			producto.setStock(producto.getStock() - cantidad);
			System.out.println("Para salir ingrese 0");
			continuar = sc.nextInt();
		} while(continuar != 0);
	}
	
	public void cargarVentas() {
		Util.loadVentas(ventas, "ventas.txt", clienteService, productoService);
	}
}
