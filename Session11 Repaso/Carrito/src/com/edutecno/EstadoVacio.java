package com.edutecno;

public class EstadoVacio implements EstadoCarrito{

	@Override
	public void agregar() {
		System.out.println("Producto agregado");
	}

	@Override
	public void cancelar() {
		System.out.println("El carrito ya esta vacio");
	}

	@Override
	public void volver() {
		System.out.println("No se puede volver, ya esta vacio");
	}

	@Override
	public void siguiente() {
		System.out.println("No se puede seguir con el carrito vacio");
	}

	@Override
	public String toString() {
		return "EstadoVacio";
	}
	
	
}
