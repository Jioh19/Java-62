package com.edutecno;

import java.util.Arrays;
import java.util.Comparator;

public class EjerciciosArreglos {
	public static void main(String[] args) {
		int[] miArreglo = { 123, 456, 4, 1, 465, 55, 7, 8, 69 };
		
		//System.out.println(miArreglo.length); //miArreglo.length me entrega el largo del arreglo
		int total = 0;
//		for(int i = 0; i < miArreglo.length; i++) {
//			System.out.println(miArreglo[i]);
//			total += miArreglo[i]; // total = total + i
//		}	
		
//		for(int num: miArreglo) {
//			System.out.println(num);
//			total += num;
//		}
//		System.out.println("El total de los numeros es de " + total);
		
		Persona persona1 = new Persona("Juan", 43, "Oh");
		Persona persona2 = new Persona("Marcelo", 25, "Toro");
		Persona persona3 = new Persona("Fernando", 33, "Robledo");
		Persona persona4 = new Persona("Diego", 40, "Escurra");
		Persona persona5 = new Persona("Manuel", 30, "Bustamante");
 		
		//Persona[] personas = {persona1, persona2, persona3, persona4, persona5};
		
		Persona[] personas = new Persona[5];
		personas[0] = persona1;
		personas[1] = persona2;
		personas[2] = persona3;
		personas[3] = persona4;
		personas[4] = persona5;

		for(int i = 0; i < personas.length; i++) {
			System.out.println(personas[i]);
		}
		
		double promedio = 0;
		for(Persona persona: personas) {
			promedio += persona.getEdad();
		}
		promedio /= personas.length;
		
		System.out.println("El promedio de edades es de: " + promedio);
		
		Arrays.stream(personas).forEach(System.out::println);
		
//		for(int j = 0; j < personas.length; j++) {
//			for(int i = 0; i < personas.length - j -1; i++) {
//				if(personas[i].getEdad() > personas[i+1].getEdad()) {
//					Persona aux = personas[i];
//					personas[i] = personas[i+1];
//					personas[i+1] = aux;
//				}
//			}
//			
//		}
		Arrays.sort(personas, Comparator.comparingInt(Persona::getEdad));
		Arrays.stream(personas).forEach(persona -> 
			System.out.println(persona.getNombre() + " " + persona.getEdad()));
	}
}
