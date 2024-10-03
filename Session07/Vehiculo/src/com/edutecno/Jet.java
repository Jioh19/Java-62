package com.edutecno;

public class Jet extends VehiculoAereo implements IDisparador{

	@Override
	public void disparar() {
		System.out.println("bang bang bang");
		
	}

	@Override
	public void despegar() {
		System.out.println("Despegando");
		
	}

	@Override
	public void aterrizar() {
		System.out.println("Aterrizando");
		
	}

	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		
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
