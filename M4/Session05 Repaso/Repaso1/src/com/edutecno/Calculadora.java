package com.edutecno;

import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String menu = """
				******************
				* 1- Sumar       *
				* 2- Restar      *
				* 3- Multiplicar *
				* 4- Dividir     *
				* 5- Salir       *
				******************""";
		int op;
		do {
			System.out.println(menu);
			// EN el caso de que se quieran usar caracteres habria que usar 
			// sc.next().charAt(0);
			op = sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Ingrese el primer número");
				int num1 = sc.nextInt();
				System.out.println("Ingrese el segundo número");
				int num2 = sc.nextInt();
				int total = num1 + num2;
				System.out.println("El total es de " + total);
				break;
			case 2:
				System.out.println("Ingrese el primer número");
				num1 = sc.nextInt();
				System.out.println("Ingrese el segundo número");
				num2 = sc.nextInt();
				total = num1 - num2;
				System.out.println("El total es de " + total);
				break;
			case 3:
				System.out.println("Ingrese el primer número");
				num1 = sc.nextInt();
				System.out.println("Ingrese el segundo número");
				num2 = sc.nextInt();
				total = num1 * num2;
				System.out.println("El total es de " + total);
				break;
			case 4:
				System.out.println("Ingrese el primer número");
				num1 = sc.nextInt();
				System.out.println("Ingrese el segundo número");
				num2 = sc.nextInt();
				double total2 = (double)num1 / (double)num2;
				System.out.printf("El total es de %.2f\n", total2);
				break;
			case 5: 
				System.out.println("Gracias por usar la Calculadora");
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}
		} while(op != 5);
		sc.close();
	}
}
