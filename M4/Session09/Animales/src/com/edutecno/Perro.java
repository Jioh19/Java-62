package com.edutecno;

public class Perro<T> {
	private String nombre;
	private T raza;
	public Perro(String nombre, T raza) {
		super();
		this.nombre = nombre;
		this.raza = raza;
	}
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + "]";
	}

	
}
