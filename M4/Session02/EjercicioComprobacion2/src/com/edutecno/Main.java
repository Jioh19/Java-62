package com.edutecno;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el valor del producto 1");
		int total = sc.nextInt();
		System.out.println("Ingrese el valor del producto 2");
		total += sc.nextInt();
		System.out.println("Ingrese el valor del producto 3");
		total += sc.nextInt();
		System.out.println("Ingrese el valor del producto 4");
		total += sc.nextInt();
		System.out.println("Ingrese el valor del producto 5");
		total += sc.nextInt();
		

		
		if(total < 10000) {
			System.out.printf("%s pagarás con efectivo el total de: %d\n",
					nombre, total);
		} else if(total < 20000) { // if(total >= 10000 && total < 20000)
			System.out.println(nombre + " pagarás con tarjeta el total de: "+ total);
		} else {
			System.out.println(nombre + " pagarás con cheque el total de: "+ total);
		}
	}
}
