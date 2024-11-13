package com.edutecno;

public class Resumen {

	public static void main(String[] args) {
		//Crear arreglos!
		
		int[] arregloInt = {1, 2, 3}; //Con inicializacion
		String arregloString[]; // Arreglo declarado de la segunda forma sin inicializacion
		int[] arregloInt2 = new int[5]; //Arreglo declardo e inicializado de tamaño 5
		arregloString = new String[2]; // Arreglo previamente declarado, ahora inicializade de tamaño 2
		
		//Obtener el largo de un arreglo
		
		int largo = arregloInt.length; // Esto retorna el valor del largo del arreglo (3)
		
		//Asignar valores a un arreglo
		
		arregloInt[0] = 123; // Asignamos el valor 123 a la posicion 0 del arregloInt
		arregloString[1] = "Hola como estan"; // Asignamos el valor "Hola como estan" al arregloString posicion 1
		
		//Navegar los datos de un arreglo
		
		for(int i = 0; i < arregloInt.length; i++) {	// Imprime en pantalla todos los valores del arregloInt
			System.out.println(arregloInt[i]);
		} 			
		
		for(String str: arregloString) {	//Imprime en pantalla todos los valores del arregloString
			System.out.println(str);
		}
		
		// Crear un arreglo Personas
		
		Persona[] miPersonas = new Persona[2]; //Declaramos e inicializamos el arreglo de Personas miPersonas de tamaño 2
		
		
		
	}

}
