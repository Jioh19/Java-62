package com.edutecno;

public class Persona {
	private String nombre;
	private String apellido;
	private String rut;
	private int edad;
	
	public Persona() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
	//Excepcion de tipo checked. Obligatorio lanzar una excepcion.
	public void setApellido(String apellido) throws PersonaExcepcion {
		if(apellido.length() < 3) {
			throw new PersonaExcepcion("El apellido necesita minimo 3 letras ");
		}
		this.apellido = apellido;
		
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + ", edad=" + edad + "]";
	}
	public int getEdad() {
		return edad;
	}
	
	//Excepcion de tipo Unchecked, no es necesario lanzar nada
	public void setEdad(int edad) {
		if(edad < 18) {
			throw new PersonaUncheckedExcepcion("Persona menor de edad");
		}
		this.edad = edad;
	}
	
	
}
