package com.edutecno.menu;

public final class Menu {

	private static Menu instance;
	private String menuCliente;

	private Menu() {
		menuCliente = """
				*****************************
				* 1- Crear Cliente          *
				* 2- Modificar Cliente      *
				* 3- Eliminar Cliente       *
				*****************************""";
	}
	
	public static Menu getMenu() {
		if(instance == null) {
			instance = new Menu();
		}
		return instance;
	}
	
	public void menuCliente() {
		System.out.println(menuCliente);
	}
	
}
