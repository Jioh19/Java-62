package com.edutecno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		//Los genéricos solo aceptan objetos. No tipos primitivos
		//Ej en vez de "int", usar "Integer"
		List<Persona> numeros = new LinkedList<>();
		
		//Agregar elementos al final de la lista con add()
		Persona juan = new Persona("Juan");
		numeros.add(juan);
		numeros.add(new Persona("Marcelo"));
		numeros.add(new Persona("Hatsumomo"));
		numeros.add(juan);
		//Obtener un elemento en el indice i con get(i)
		Persona nombre = numeros.get(1);
		//Eliminar un elmento en el indice i con remove(i). Solo elimina 
		//la primera instancia.
		//numeros.remove(juan);
		while(numeros.contains(juan)) {
			numeros.remove(juan);
		}
		List<List<Persona>> muchasPersonas = new ArrayList<>();
		System.out.println(numeros);
		System.out.println(String.valueOf(numeros.contains("Hatsumomo")) + " " + nombre);
	}
}
