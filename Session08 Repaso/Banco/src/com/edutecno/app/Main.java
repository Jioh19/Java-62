package com.edutecno.app;

import java.util.Arrays;

import com.edutecno.cliente.Cliente;
import com.edutecno.cliente.Nivel;
import com.edutecno.cuenta.*;
import com.edutecno.menu.Menu;

public class Main {

	public static void main(String[] args) {
		Cliente[] clientes = Init.cargarClientes();
		System.out.println(Arrays.toString(clientes));
		Menu menu = Menu.getMenu();
		menu.menuCliente();
		
	}

}
