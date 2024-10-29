package com.edutecno.calculadora;

public class Calculadora {
	public int sumar(int a, int b) {
		System.out.println(a + b);
		return a + b;
	}

	public int restar(int a, int b) {
		System.out.println(a - b);
		return a - b;
	}

	public int multiplicar(int a, int b) {
		System.out.println(a * b);
		return a * b;
	}

	public int dividir(int a, int b) {
		System.out.println(a / b);
		return a / b;
	}
	
	public String adjuntar(String a, String b) {
		return (a + b);
	}
}