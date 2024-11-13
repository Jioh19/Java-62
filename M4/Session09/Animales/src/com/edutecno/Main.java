package com.edutecno;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Perro perro1 = new Perro("Max", "Pastor Alemán");
		Perro perro2 = new Perro("Neron", true);
		Perro perro3 = new Perro("Fifi", 123);
		Gato gato = new Gato("Ratanaz");
		
		CajaMascota caja = new CajaMascota();
		ArregloMascota mascotas = new ArregloMascota();
		System.out.println(perro1);
		System.out.println(perro2);
		System.out.println(perro3);
		Perro[] perros = {perro1, perro2, perro3};
		mascotas.setMascotas(perros);
		
		System.out.println(mascotas.getMascotas()[1].getClass().getTypeName());
		caja.setMascota(perro3);
		System.out.println(caja);
	}

}
