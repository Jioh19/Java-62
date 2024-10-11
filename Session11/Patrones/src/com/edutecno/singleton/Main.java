package com.edutecno.singleton;

public class Main {
	public static void main(String[] args) {
		//Instanciamos 2 clientes para verificar si se crea solo 1 instancia
		Cliente cliente1 = Cliente.getCliente();
		Cliente cliente2 = Cliente.getCliente();
		cliente1.setNumero(100);
		cliente2.setNumero(69);
		//Finalmente vemos que ambas instancias son la misma, si cambia 1, cambia 2 también
		System.out.println("Cliente 1: " + cliente1.getNumero() + 
				"\nCliente 2: " + cliente2.getNumero());
	}
}
