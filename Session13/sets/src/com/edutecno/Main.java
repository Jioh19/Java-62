package com.edutecno;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<String> frutas = new HashSet<>();
		
		//para agregar elementos utilizar add(obj)
		
		frutas.add("Manzana");
		frutas.add("Pera");
		frutas.add("Naranja");
		boolean agregado = frutas.add("Manzana");

		// Los sets no respetan el orden pero si respetan la unicidad de sus elementos.
		System.out.println("Se agrego la segunda manzana? " + agregado);
		
		
		//Tanto set, como map, utilizan el método equals. Hay que sobrecargarlo al igual
		//que el método hashcode.
		HashSet<Persona> personas = new HashSet<>();
		Persona juan = new Persona("Juan", "Oh", "15335679-3");
		Persona marcelo = new Persona("Marcelo", "Toro", "12341567-8");
		Persona juan2 = new Persona("Juanin", "OhKim", "15335679-3");
		
		personas.add(juan);
		personas.add(marcelo);
		personas.add(juan2);
		
		System.out.println(personas);
		System.out.println(juan.equals(juan2));
	}
	
}
