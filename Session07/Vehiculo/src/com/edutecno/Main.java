package com.edutecno;

public class Main {
	public static void main(String[] args) {
		VehiculoAereo cesna = new Avion("Cesna");
		Vehiculo lancha = new Barco();
		
		cesna.avanzar();
		cesna.despegar();
		cesna.aterrizar();
		
		lancha.avanzar();
		((VehiculoMarino) lancha).zarpar();
		
		
		Vehiculo f14 = new Jet();
		Vehiculo HMSIntelligence = new PortaAviones();
		
		((IDisparador)f14).disparar();
		((IDisparador)HMSIntelligence).disparar();
	}
}
