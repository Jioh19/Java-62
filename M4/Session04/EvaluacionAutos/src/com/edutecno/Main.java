package com.edutecno;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese marca, modelo, color, velocidadMaxima");
		String marca = sc.next();
		String modelo = sc.next();
		String color = sc.next();
		Double velocidadMaxima = sc.nextDouble();
		
		Auto auto = new Auto(marca, modelo, color, velocidadMaxima);
		System.out.println("Felicidades por su nuevo Auto" + auto);
		String menu = """
				Seleccione que desea hacer
				1- Encender auto
				2- Apagar auto
				3- Acelerar auto
				4- Salir""";
		int eleccion;
		do {
			System.out.println(menu);
			eleccion = sc.nextInt();
			
			switch(eleccion) {
			case 1:
				boolean resultado = auto.encender();
				if(resultado) {
					System.out.println("Auto encendido exitosamente!!!");
				}
				break;
			case 2:
				resultado = auto.apagar();
				if(resultado) {
					System.out.println("Auto apagado exitosamente!!!");
				}
				break;
			case 3:
				resultado = auto.acelerar();
				if(!resultado) {
					System.out.println("Auto no pudo acelerar");
				}
				break;
			case 4:
				System.out.println("Gracias por usar la app");
				break;
			default:
				System.out.println("Ingrese un valor válido");
			}
		} while(eleccion != 4);
		
	}

}
