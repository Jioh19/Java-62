package com.edutecno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* Función recursiva que provoca un stackoverflow. De esta no hay recuperación, es un error */
//		try {
//			func();
//			
//		} catch(Exception e) {
//			System.out.println("Capturamos el overflow ");
//		}
		//Nos permite intentar la ejecucion de un programa, y en el caso de que haya problemas,
		//nos da la posibilidad de corregir.
		int intento = 3;
		while(true) {
			
			try {
				System.out.println("Ingrese un numero");
				int numero = sc.nextInt();
				System.out.println("Su numero es " + numero);
				// Este da ArithmeticException
//			int division = numero/0;
//			System.out.println(division);
				
				//Try anidado.
//				try {
//					int numero2 = sc.nextInt();
//					System.out.println("Su numero es " + numero2);
//				}catch(InputMismatchException e) {
//					System.out.println("Ingrese un número válido para numero2 " + e);
//				}
				
				break;
			} catch(InputMismatchException e) {
				//Diferencia entre el post decremento y el pre decremento
				if(intento-- == 0) {
					System.out.println("Cantidad de intentos sobrepasada");
			
					break;
				}
				System.out.println("Ingrese un número válido, cantidad de intentos: " + intento);
				sc.next();
			} catch(Exception e) {
				System.out.println("Excepcion random " + e );
			} finally {
				System.out.println("Esta cosa siempre se ejecuta");
//				sc.close();
			}
		}
		System.out.println("Gracias por participar");
	}

//	public static void func() {
//		func();		
//	}
}
