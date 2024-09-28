package com.edutecno;

import java.util.Scanner;

public class ControlFlujo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int selector = sc.nextInt();
		if (selector > 10) {
			System.out.println("Es mayor a 10");
		} else {
			System.out.println("Es menor o igual a 10");
		}

		int dia = sc.nextInt();
		switch (dia) {
		case 1:
			System.out.println("Es lunes");
			break;
		case 2:
			System.out.println("Es martes");
			break;
		default:
			System.out.println("No se que día es");
			break;
		}
		
		System.out.println("Ciclo for");
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		System.out.println("Ciclo while");
		int num = 0;
		while(num < 10) {
			System.out.println(num);
			num++;
		}
		
		System.out.println("Ciclo do while");
		num = 0;
		do {
			System.out.println(num);
			num++;
		}while(num < 10);
		
		sc.close();
	}
}
