package com.edutecno;

public class Main {
	public static void main(String[] args) {
		ListaArreglo<String> arr = new ListaArreglo<String>();
		arr.add("Hola");
		arr.add("mundo");
		arr.add("CHAO");
		arr.add("Hola");
		arr.add("mundo");
		arr.add("CHAO");
		arr.add("Hola");
		arr.add("mundo");
		arr.add("CHAO");
		arr.add("Hola");
		arr.add("mundo");
		arr.add("CHAO ESPECIAL");
		
		
		System.out.println(arr);
		System.out.println(arr.get(8));
	}
}
