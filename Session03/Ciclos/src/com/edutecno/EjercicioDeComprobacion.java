package com.edutecno;

import java.util.Scanner;

public class EjercicioDeComprobacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Patron 1 *.
		//Patron 2 ******
		// *     *
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el numero mayor 2");
		int num = sc.nextInt();
		
		System.out.println("patron 1:");
		String patron1 = "";
		for(int i = 0; i < num; i++) {
			if(i %2 == 0 ) {
				patron1 += "*";
			} else {
				patron1 += ".";
			}
		}
		System.out.println(patron1);
		
		System.out.println("patron 2:");
		String patron2 = "******\n";
		
		for(int i = 0; i < num-2; i++ ) {
			patron2 += "*    *\n";
		}
		patron2 += "******\n";
		System.out.println(patron2);
	}

}
