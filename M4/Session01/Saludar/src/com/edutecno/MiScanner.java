package com.edutecno;

import java.util.Scanner;

public class MiScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		String nombre = scanner.nextLine();
		System.out.println("Mi nombre es " + nombre);
		System.out.println("Ingresa tu edad");
		int edad = scanner.nextInt();
		
		System.out.println("Tu edad es de " + edad);
		scanner.nextLine();
		
		String direccion = scanner.nextLine();
		System.out.println("Tu direccion es " + direccion);
		System.out.println("Termino la ejecucion");
		scanner.close();
	}

}
