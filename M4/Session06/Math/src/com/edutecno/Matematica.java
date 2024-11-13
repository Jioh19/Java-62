package com.edutecno;

import java.util.Random;

public class Matematica {

	public static void main(String[] args) {
		double numero = Math.PI;
		System.out.println(numero);
		int rand = (int) (Math.random() * 100);
		
		// Curiosidad, la clase Random es el doble de eficiente que Math.random()
		
		Random random = new Random();
		int aleatorio = random.nextInt(100);
		
		System.out.println(rand);
		System.out.println(aleatorio);
		
		// Continuando con math
		
		Math.abs(-5); // es igual a 5
		Math.pow(rand, aleatorio);
		
	}
	

}
