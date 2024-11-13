package com.edutecno;

public class Empleado {
	private String nombre;

	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void trabajar() {
		System.out.println("Estoy trabajando");
		
	}
	
	public void getSueldo() {
		System.out.println("Recibiendo el sueldo");
	}
	
}
