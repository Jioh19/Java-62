package com.edutecno;

public class Robot implements Trabajador{

	@Override
	public void trabajar() {
		System.out.println("Trabjando");
	}

	@Override
	public void cobrar() {
		throw new UnsupportedOperationException("El robot no cobra!");
	}

	@Override
	public void descanzar() {
		throw new UnsupportedOperationException("El robot no descanza!");
	}

}
