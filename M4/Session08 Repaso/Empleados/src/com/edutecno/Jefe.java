package com.edutecno;

public class Jefe extends Empleado{

	public Jefe(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trabajar() {
		System.out.println("Todos a trabajar");
	}
	
	public void agregarEmpleado() {
		System.out.println("Agregue un nuevo empleado");
	}

}
