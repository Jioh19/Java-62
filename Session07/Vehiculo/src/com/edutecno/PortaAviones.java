package com.edutecno;

public class PortaAviones extends VehiculoMarino implements IDisparador {

	@Override
	public void disparar() {
		System.out.println("pewpewpewpewpew");

	}

	@Override
	public void zarpar() {
		System.out.println("Zarpando");

	}

	@Override
	public void atracar() {
		System.out.println("Atracando");
	}

	@Override
	public void avanzar() {
		System.out.println("Avanzando");

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
