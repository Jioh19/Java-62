package com.edutecno;

public class Ejercicios {
	public static void main(String[] args) {
//		imprimirInverso(20);
//		imprimirTablas(5);
//		sumatoria(10);
//		int resultado = sumaRecu(100);
//		System.out.println("El resultado de la suma recursiva es de " + resultado);
//		int resuFacto = factorial(5);
//		System.out.println("El resultado del factorial recursivo es de " + resuFacto);
//		facto(5);
		fibonaci(8);
		long primo = 1203141422222341517l;
		System.out.printf("El numero %d es primo? %b", primo, prime(primo));
	}

	// Esta funcion imprime desde el numero hasta llegar al 0
	public static void imprimirInverso(int num) {
		while (num >= 0) {
			System.out.println(num);
			num--;
		}
	}

	// Esta funcion imprime la tabla de "num" desde 1 hasta 10
	public static void imprimirTablas(int num) {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d\n", num, i, num * i);
		}
	}

	// Esta funcion imprime el resultado de una sumatoria
	public static void sumatoria(int num) {
		int total = 0;
		while (num > 0) {
			total += num;
			num--;
		}
		System.out.println("El total de la sumatoria es de " + total);
	}

	public static int sumaRecu(int num) {
		if (num == 0) {
			return 0;
		}
		return num + sumaRecu(num - 1);
	}

	// 5! = 2 * 3 * 4 * 5

	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		}
		return num * factorial(num - 1);
	}
	
	public static void facto(int num) {
		int total = 1;
		for(int i = 1; i <= num; ++i) {
			total *= i;
		}
		System.out.println("El factorial es de " + total);
	}

	public static void fibonaci(int num) {
		int num1 = 0;
		int num2 = 1;
		for(int i = 2; i < num; i++) {
			int aux = num1;
			num1 = num2;
			num2 = aux+num1;
		}
		System.out.println(num2);
	}
	
	public static boolean prime(long num) {
		boolean isPrime = true;
		for(int i = 2; i < Math.sqrt(num); ++i) {
			if(num%i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
