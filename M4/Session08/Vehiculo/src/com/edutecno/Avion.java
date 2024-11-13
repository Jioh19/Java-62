package com.edutecno;

public class Avion extends VehiculoAereo{
	private String nombre;
	
	
	
	public Avion(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void despegar() {
		System.out.println(this.nombre + " despegando!!!");
		
	}

	@Override
	public void aterrizar() {
		System.out.println(this.nombre + " aterrizando!!!");
		
	}

	@Override
	public void avanzar() {
		System.out.println(this.nombre + " avanzando!!!");
		
	}

	@Override
	public void doblar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void frenar() {
		// TODO Auto-generated method stub
		
	}

}
