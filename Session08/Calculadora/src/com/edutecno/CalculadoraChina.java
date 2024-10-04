package com.edutecno;

import java.util.Random;

public class CalculadoraChina extends Calculadora{

	@Override
	public int sumar(int num1, int num2) {
		// TODO Auto-generated method stub
		return super.sumar(num1, num2) + (int)(Math.random() * 2);
	}

	@Override
	public double sumar(double num1, double num2) {
		// TODO Auto-generated method stub
		return super.sumar(num1, num2) + (Math.random() * 2);
	}

	@Override
	public double sumar(double num1, double num2, double num3) {
		// TODO Auto-generated method stub
		return super.sumar(num1, num2, num3) + (Math.random() * 2);
	}

	@Override
	public int sumar(int... arr) {
		// TODO Auto-generated method stub
		// Random.nextInt(1000)
		Random rand = new Random();
		return super.sumar(arr) + rand.nextInt(2); // Math.random() == entrega numero aleatorio entre 0 y 1
	}

	
}
