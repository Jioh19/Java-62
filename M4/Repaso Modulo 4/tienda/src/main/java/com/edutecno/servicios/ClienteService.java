package com.edutecno.servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.edutecno.modelos.Cliente;
import com.edutecno.utils.Util;

public class ClienteService {
	private Map<String, Cliente> clientes;

	public ClienteService() {
		super();
		clientes = new HashMap<>();
	}
	
	private Cliente crearCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese id");
		String id = sc.next();
		System.out.println("Ingrese nombre");
		
		//Ojo, este nextline esta para consumir el salto de linea que quedo en el buffer
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Ingrese apellido");
		String apellido = sc.next();
		System.out.println("Ingrese direccion");
		sc.nextLine();
		String direccion = sc.nextLine();
		System.out.println("Ingrese telefono");
		String telefono = sc.next();
		System.out.println("Ingrese email");
		String email = sc.next();
		Cliente cliente = new Cliente(
				id, nombre, apellido, direccion, telefono, email);
		return cliente;
	}
	
	public void agregarCliente() {
		Cliente cliente = crearCliente();
		clientes.put(cliente.getId(), cliente);
	}
	
	public void mostrarCliente() {
		for(String keys: clientes.keySet()) {
			System.out.println(clientes.get(keys));
		}
	}
	
	public void cargarClientes() {
		Util.loadCliente(clientes, "clientes.txt");
	}
	
	public void guardarClientes() {
		Util.save(clientes, "clientes.txt");
	}
	
	public Cliente obtenerCliente(String id) {
		return clientes.get(id);
	}
}
