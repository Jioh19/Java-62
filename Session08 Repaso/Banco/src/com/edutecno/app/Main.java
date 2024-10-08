package com.edutecno.app;

import java.util.Arrays;
import java.util.Scanner;

import com.edutecno.cliente.Cliente;
import com.edutecno.cliente.MenuCliente;
import com.edutecno.cliente.Nivel;
import com.edutecno.cliente.ServiceCliente;
import com.edutecno.cuenta.*;
import com.edutecno.menu.Menu;

public class Main {

	public static void main(String[] args) {
		Cliente[] clientes = Init.cargarClientes();
		System.out.println(Arrays.toString(clientes));

		ServiceCliente service = new ServiceCliente(clientes);
		Scanner sc = new Scanner(System.in);
		boolean sigue = true;
		while (sigue) {
			MenuCliente.menuCliente();
			int eleccion = sc.nextInt();
			switch (eleccion) {
			case 1:
				service.agregarCliente();
				break;
			case 4:
				service.mostrarClientes();
				break;
			default:
				sigue = false;
			}
			
		}
		System.out.println("Gracias por usar el super banco");
	}

}
