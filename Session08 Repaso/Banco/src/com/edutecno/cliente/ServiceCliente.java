package com.edutecno.cliente;

import java.util.Arrays;
import java.util.Scanner;

public class ServiceCliente {

	private Cliente[] clientes;
	
	
	
	public ServiceCliente(Cliente[] clientes) {
		super();
		this.clientes = clientes;
	}

	public void agregarCliente() {
		for(int i = 0; i < clientes.length; i++) {
			if(clientes[i] == null) {
				clientes[i] = crearCliente();
				break;
			}
		}
	}

	private Cliente crearCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese nombre");
		String nombre = sc.next();
		System.out.println("Ingrese apellido");
		String apellido = sc.next();
		System.out.println("Ingrese rut");
		String rut = sc.next();
		Cliente cliente = new Cliente(nombre, apellido, rut, Nivel.BASICO);
		return cliente;
	}

	public void mostrarClientes() {
		System.out.printf("*%10s %10s %10s %10s *\n", "Nombre", "Apellido", "Rut", "Nivel");
		for(Cliente cliente: clientes) {
			if(cliente != null) {
				System.out.printf("*%10s %10s %10s %10s *\n", cliente.getNombre(),
						cliente.getApellido(), cliente.getRut(), cliente.getNivel());
			}
		}
	}
	
	
}
