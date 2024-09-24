package com.edutecno;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

//		boolean resultado = (1 != 1); //ligatures ! =
//		System.out.println(resultado);
		Scanner sc = new Scanner(System.in);
//		System.out.println("Ingrese su edad");
//		
//		int edad = sc.nextInt();
//		System.out.println("Ingrese su sexo");
//		String sexo = sc.next();

//		if (edad >= 65) {
//			System.out.println("Bienvenido señor " + edad);
//		} else if (edad >= 18) {
//			System.out.println("Bienvenido!!!!");
//		} else {
//			System.out.println("Fuera!! eres menor de edad");
//		}
//		if (edad >= 18) {
//			if(sexo.toLowerCase().equals("hombre")) { 
//				System.out.println("Bienvenido hombre");
//			}
//			else if(sexo.equals("mujer"))  {
//				System.out.println("Bienvenida mujer");
//			} else {
//				System.out.println("Ingrese ....");
//			}
//		} else {
//			System.out.println("Chao!");
//		}
//		
//		String menu = """
//				*****************************
//				* 1- Ingresa nombre         *
//				* 2- Ingresa apellido       *
//				* 3- Ingresa edad           *
//				*****************************
//				""";
//		System.out.println(menu);
//		int eleccion = sc.nextInt();
//		switch (eleccion) {
//		case 1:
//			System.out.println("Ingrese nombre");
//			String nombre = sc.next();
//			System.out.println("Tu nombre es " + nombre);
//			
//		case 2: 
//			System.out.println("Ingrese apellido");
//			String apellido = sc.next();
//			System.out.println("Tu apellido es " + apellido);
//	
//		case 3:
//			System.out.println("Ingrese edad");
//			int edad = sc.nextInt();
//			System.out.printf("Tu edad es de %d años\n", edad);
//			break;
//		default:
//			System.out.println("Ingrese opción válida");
//				
//		}

//		System.out.println("Ingrese sexo");
//		String sexo = sc.next();
//		
//		switch (sexo) {
//		case "hombre":
//			System.out.println("Soy hombre!");
//			break;
//		case "mujer":
//			System.out.println("Soy mujer!");
//			break;
//		default:
//			System.out.println("No soy binarie");
//				
//		}
//		System.out.println("Ingrese sexo");
//		String sexo = sc.next();
//		
//		switch (sexo.charAt(0)) {
//		case 'h':
//			System.out.println("Soy hombre!");
//			break;
//		case 'm':
//			System.out.println("Soy mujer!");
//			break;
//		default:
//			System.out.println("No soy binarie");
//				
//		}
//		System.out.println("Ingrese sexo");
//		double sexo = sc.nextDouble();
//		
//		switch (sexo) {
//		case 1.1:
//			System.out.println("Soy hombre!");
//			break;
//		case 2.1:
//			System.out.println("Soy mujer!");
//			break;
//		default:
//			System.out.println("No soy binarie");
//				
//		}

		double temperatura = 17;

//		if (temperatura > 30 || temperatura < 15) {
//			System.out.println("Mala temperatura");
//		} else {
//			System.out.println("temperatura piola");
//		}
		
		//(condicion) ? verdadero: falso
		System.out.println((temperatura > 30 || temperatura < 15) ?
				"Mala temperatura": "temperatura piola");
		System.out.println((temperatura < 30 && temperatura > 15 ? 
				"temperatura piola": "Mala temperatura"));

	}

}
