package com.edutecno;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese username");
		String user = sc.next();
		System.out.println("Ingrese password");
		String password = sc.next();
		System.out.println("Ingrese nombre");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Ingrese año de nacimiento");
		int anio = sc.nextInt();
		System.out.println("Ingrese mes de nacimiento");
		int mes = sc.nextInt();
		System.out.println("Ingrese día de nacimiento");
		int dia = sc.nextInt();
		
		
		
		Persona juan = new Persona(user, password, nombre, LocalDate.of(anio, mes, dia));
		System.out.println(juan.charaPass());
		System.out.println(juan.regexCharaPass());
	}

}
