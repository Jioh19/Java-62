package com.edutecno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		VehiculoAereo cesna = new Avion("Cesna");
		Vehiculo lancha = new Barco();
		Vehiculo HMSIntelligence = new PortaAviones();
		Vehiculo f14 = new Jet();
		
		Vehiculo[] vehiculos = {cesna, lancha, HMSIntelligence, f14};
		
		List<Integer> listas = new ArrayList<>();
		
		for(Vehiculo veh: vehiculos) {
			veh.avanzar();
			System.out.println(veh.getClass().getTypeName());
			if(veh instanceof PortaAviones) {
				((PortaAviones) veh).disparar();				
			} else if(veh instanceof Jet) {
				((Jet) veh).disparar();
				
			}
		}
	}
}
