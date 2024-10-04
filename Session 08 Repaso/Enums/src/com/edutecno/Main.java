package com.edutecno;

public class Main {

	public static void main(String[] args) {
		Fruta manzana = new Fruta("Manzana", 0.5);
		manzana.madurez = Madurez.PODRIDA;
		System.out.println(manzana);
	}
	
}
