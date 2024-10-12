package com.edutecno;

public class EstadoCerrado implements EstadoCarrito{

	@Override
	public void agregar() {
		System.out.println("No se puede agregar, carrito cerrado");
	}

	@Override
	public void cancelar() {
		System.out.println("No se puede cancelar, carrito cerrado");
	}

	@Override
	public void volver() {
		System.out.println("No se puede volver, carrito cerrado");
	}

	@Override
	public void siguiente() {
		System.out.println("Carrito vaciado");
	}

	@Override
	public String toString() {
		return "EstadoCerrado";
	}

	
}
