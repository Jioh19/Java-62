package com.edutecno;

public class Calculadora {

	public int sumar(int num1, int num2) {
		return num1 + num2;
	}
	
	public double sumar(double num1, double num2) {
		return num1 + num2;
	}
	
	public double sumar(double num1, double num2, double num3) {
		return num1 + num2 + num3;
	}
	
	public int sumar(int... arr) {
		int total = 0;
		for(int num: arr) {
			total += num;
		}
		return total;
	}
}
