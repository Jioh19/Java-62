package com.edutecno;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	class Ejercicio1 {
		public static int dividir(int num1, int num2) {
			try {
				return num1 / num2;
			} catch (ArithmeticException e) {
				System.out.println("Error" + e);
				return 0;
			}
		}
	}

	class EdadException extends Exception {

		private static final long serialVersionUID = 1L;

		public EdadException(String message) {
			super(message);
		}
	}
	
	class Ejercicio3 {
		public static void procesarNumero(String[] arr, int index) {
			try {
				int numero = Integer.parseInt(arr[index]);
				System.out.println("El numero procesado: " + numero);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Indice fuera del arreglo" + e.getMessage());
			} catch(NumberFormatException e) {
				System.out.println("No es un numero " + e.getMessage());
			}
		
		}
		
	}
	
	class Ejercicio4 {
		public static void leer(String fileName) {
			try {
				Scanner sc = new Scanner(new File(fileName));
			} catch(FileNotFoundException e) {
				System.out.println("No existe el archivo " + e);
			}
		}
	}
	
	class Ejercicio5 {
		public static void metodoA() throws Exception {
			throw new Exception("Error en el metodo A");
		}
		
		public static void metodoB() throws Exception {
			metodoA();
		}
		
		public static void metodoC() {
			try {
				metodoB();
			} catch (Exception e) {
				System.out.println("Hemos ejecutado el metodo A " + e );
			}
		}
	}

	public static void main(String[] args) {

		System.out.println(Ejercicio1.dividir(10, 0));
		String[] arr = {"123456", "hola"};
		Ejercicio3.procesarNumero(arr, 5);
		Ejercicio4.leer("texto.txt");
		Ejercicio5.metodoC();
	}

}
