package com.edutecno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//int Integer numero entero
		//double Double numero decimal
		//String cadena de caracteres
		String nombre = "Juan Oh Kim";
		System.out.println("Hola Mundo");
		System.out.println(nombre);
		String menu = """
				-----==========-----
				-    BIENVENIDO    -
				-----==========-----
				- 1- Entrar        -
				- 2- Salir         -
				-----==========-----""";
		System.out.println(menu);
		System.out.print(nombre);
		System.out.print(nombre);
		String aster = "\n***********************************";
		System.out.println(aster);
		System.out.printf("*  %15s %15d*\n\n", "Juan123456789012345", 123);
		
		//Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner("Hola mundo!! como estan todos?");
		FileReader fr = new FileReader("input.txt");
		Scanner scanner = new Scanner(fr);
		BufferedReader bf = new BufferedReader(fr);
		String miNombre = scanner.next();
		String apellido = scanner.next();
		String segundoApellido = scanner.next();
		System.out.println("Mi nombre completo es " + miNombre + " " + apellido + " " +segundoApellido);
		System.out.printf("Mi nombre completo es %s %s %s", miNombre, apellido, segundoApellido);
		
		//scanner.nextLine();
		String linea = scanner.nextLine();
		System.out.println(linea);
		System.out.println(bf.readLine());
	}

}
