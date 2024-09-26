package com.edutecno;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Este es mi comentario 1 linea
		/* Este es mi comentario de bloque
		 * puedo hacer hartas lineas
		 */
		int i = 0;
//		while(i < 100) {
//			System.out.println("El valor de i es de " + i);
//			i += 2; // i = i + 1;
//			//i++;
//		}
		
//		for(int j = 0; j < 20; j++) {
//			System.out.println("El valor de j es de " + j);
//		}
		Scanner scanner = new Scanner(System.in);
		int eleccion;
		do {
			String menu = """
					*****************
					* Ingrese opcion*
					* 1-leer        *
					* 2-escribir    *
					* 3-salir       *
					***************** 
					""";
			System.out.println(menu);
			eleccion = scanner.nextInt();
					
			System.out.println("El valor de i es de " + i);
			i++;
		} while(eleccion != 3);
	}

}
