package com.edutecno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona juan = new Persona("Juan", 100, 120, 1.5);
		Item espada = new Item("Espada", 5, 0.1);
		Item escudo = new Item("Escudo", 15, 0.4);
		Item armadura = new Item("Armadura", 40, 0.4);
		Item comida = new Item("Comida", 10, 0.3);
		Item martillo = new Item("Martillo", 7, 0.1);
		Item[] items = {espada, escudo, armadura, comida, martillo};
		
		for(Item item: items) {
			juan.agregarItem(item);
		}
		
		System.out.println(juan);
		System.out.println(juan.pesoTotal() + " " + juan.volumenTotal());
	}

}
