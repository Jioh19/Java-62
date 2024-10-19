package com.edutecno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persona> personas = new ArrayList<>();

		Persona juan = new Persona("Juan", "Oh", 42, "123");
		Persona marcelo = new Persona("Marcelo", "Toro", 35, "231");
		Persona jimmy = new Persona("Jimmy", "Oh", 50, "312");
		Persona diego = new Persona("Diego", "Toro", 30, "432");

		personas.add(juan);
		personas.add(marcelo);
		personas.add(jimmy);
		personas.add(diego);

		// stream() es el inicializador, forEach es un intermediario
		// Ambos for cumplen la misma funcion!.
		for (Persona persona : personas) {
			System.out.println(persona);
		}

		// Queremos sacar el promedio de las edades de las personas
		// Primero utilizaremos el método clasico
		int total = 0;
		for (Persona persona : personas) {
			total += persona.getEdad();
		}
		total /= personas.size();

		System.out.println(total);

		// Utilizaremos streams
		total = personas.stream().map(Persona::getEdad).reduce(0, Integer::sum);
		total /= personas.size();
		System.out.println(total);

		// System.out.println(personas);

		// Metodo tradicional para hacer el ordenamiento
		Collections.sort(personas);
		System.out.println("Ordenamiento usando interface Comparable");
		personas.stream().forEach(System.out::println);

		// Ordenamiento utilizando Stream
		var ordenadoApellidoNombre = personas.stream()
				.sorted(Comparator.comparing(Persona::getApellido)
						.reversed()
						.thenComparing(Persona::getNombre))
				.collect(Collectors.toList());
		System.out.println("\nOrdenamiento usando stream");
		ordenadoApellidoNombre.stream().forEach(System.out::println);
//		  
		System.out.println("\nOrdenamiento usando stream y lambda");
		var lambdaEdad = personas.stream().sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
				.collect(Collectors.toList());
		lambdaEdad.stream().forEach(System.out::println);
	}

}
