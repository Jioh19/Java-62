package com.edutecno;

public class Senior extends Empleado{

	@Override
	public void calularBonus() {
		System.out.println("Sueldo con bono " + sueldo*1.2);
		
	}

	@Override
	public void generarReportes() {
		System.out.println("No genero reportes");
		
	}

	@Override
	public void manejarProyectos() {
		System.out.println("Manejando los proyectos");
	}

}
