package com.edutecno;

public class EstadoPagando implements EstadoCarrito{

	@Override
	public void agregar() {
		System.out.println("No se puede agregar producto pagando");
	}

	@Override
	public void cancelar() {
		System.out.println("Carrito cancelado");
	}

	@Override
	public void volver() {
		System.out.println("Carrito de vuelta a cargando");
	}

	@Override
	public void siguiente() {
		System.out.println("Carrito pagado");
	}

	@Override
	public String toString() {
		return "EstadoPagando";
	}

	
}
