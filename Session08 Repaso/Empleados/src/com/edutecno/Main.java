package com.edutecno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado emp = new Empleado("Juan");
		Empleado jefe = new Jefe("Edutecno");
		
		emp.trabajar();
		emp.getSueldo();
		
		jefe.trabajar();
		((Jefe) jefe).agregarEmpleado();
	}

}
