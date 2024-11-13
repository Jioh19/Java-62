package com.edutecno;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		Persona juan = new Persona("Juan", "Oh", 42, "123");
		Persona marcelo  = new Persona("Marcelo", "Toro", 35, "231");
		Persona jimmy = new Persona("Jimmy", "Oh", 50, "312");
		Persona diego = new Persona("Diego", "Toro", 30, "432");
		
		//HashMap implementa Map y su sintaxis es de tipo HashMap<Llave, Valor>  = HashMap<K, V>
		//El treemap no permite tener una llave de tipo null
		Map<String, Persona> personas = new HashMap<>();
		personas.put(null, juan);
		personas.put(marcelo.getRut(), marcelo);
		personas.put(jimmy.getRut(), jimmy);
		personas.put(diego.getRut(), diego);
		//Ojo con las llaves. Estas son unicas, y se mantiene el último valor ingresado.
		personas.put(juan.getRut(), diego);
		
		Persona obtenida = personas.get("231");
		
		//Valor por defecto para evitar el null
		Persona obtenida2 = personas.getOrDefault("231", juan);
		System.out.println("La persona obtenida es " + obtenida);
		System.out.println("La persona get or default obtenida es " + obtenida2);
		
		//Si queremos evitar el put que pisa todo, podemos usar el putIfAbstent
		personas.putIfAbsent("124", jimmy);
		
		//Este for NO sirve!
//		for(int i = 0; i < personas.size(); i++) {
//			personas.get(i);
//		}
		
		//Escribir el for each de esta manera es una lata.
//		for(Map.Entry<String, Persona> entrada: personas.entrySet()) {
//			System.out.println("La llave es: " + entrada.getKey() + " El valor es: " + entrada.getValue());
//		}
		
		for(var entrada: personas.entrySet()) {
			System.out.println("La llave es: " + entrada.getKey() + " El valor es: " + entrada.getValue());
		}
	}

}
