package com.edutecno;

public class EstadoCargando implements EstadoCarrito{

	@Override
	public void agregar() {
		System.out.println("Producto agregado");
	}

	@Override
	public void cancelar() {
		System.out.println("Carrito cancelado");
	}

	@Override
	public void volver() {
		System.out.println("Carrito vaciado");
	}

	@Override
	public void siguiente() {
		System.out.println("Pasando al pago");
	}

	@Override
	public String toString() {
		return "EstadoCargando";
	}

	
}
