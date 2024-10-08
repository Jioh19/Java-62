package com.edutecno;

public abstract class Empleado {
	protected String nombre;
	protected int sueldo;
	protected String direccion;
	
	public abstract void calularBonus();
	public abstract void generarReportes();
	public abstract void manejarProyectos();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", direccion=" + direccion + "]";
	}
	
	
}
