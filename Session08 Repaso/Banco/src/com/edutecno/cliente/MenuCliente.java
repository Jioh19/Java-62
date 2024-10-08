package com.edutecno.cliente;

public class MenuCliente {
	private static String menu = """
			*****************************
			* 1- Crear Cliente          *
			* 2- Modificar Cliente      *
			* 3- Eliminar Cliente       *
			* 4- Mostrar Clientes       *
			*****************************""";
	public static void menuCliente() {
		System.out.println(menu);
	}
}
