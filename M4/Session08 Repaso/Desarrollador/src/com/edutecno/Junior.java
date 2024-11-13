package com.edutecno;

public class Junior extends Empleado{

	
	@Override
	public void calularBonus() {
		System.out.println("Sueldo + 10% " +  sueldo*1.1);
		
	}

	@Override
	public void generarReportes() {
		System.out.println("Generando reporte");
		
	}

	@Override
	public void manejarProyectos() {
		System.out.println("No estoy autorizado para hacer proyectos");
	}

	
}
