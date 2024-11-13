package com.edutecno;

import java.util.Arrays;

public class Persona {
	private String nombre;
	private Integer hp;
	private Item[] inventario;
	private double capacidadCarga;
	private double espacio;
	private int next;
	
	public Persona(String nombre, Integer hp, double capacidadCarga, double espacio) {
		super();
		this.nombre = nombre;
		this.hp = hp;
		this.capacidadCarga = capacidadCarga;
		this.espacio = espacio;
		this.inventario = new Item[20];
		
	}
	
	public double pesoTotal() {
		double total = 0;
		for(Item item: inventario) {
			if(item != null) {
				total += item.getPeso();
			}
		}
		return total;
	}
	
	public double volumenTotal() {
		double total = 0;
		for(int i = 0; i < inventario.length; i++) {
			if(inventario[i] != null) {
				total += inventario[i].getVolumen();
			}
		}
		return total;
	}
	
	public boolean verificarPeso(Item item) {
		if(capacidadCarga >= pesoTotal() + item.getPeso()) {
			return true;
		}
		return false;
	}
	
	public boolean verificarVolumen(Item item) {
		if(espacio >= volumenTotal() + item.getVolumen()) {
			return true;
		}
		return false;
	}
	
	public void agregarItem(Item item) {
		boolean entro = false;
		if(!verificarVolumen(item)) {
			System.out.println("No hay suficiente espacio");
			return;
		}
		if(!verificarPeso(item)) {
			System.out.println("No hay capacidad de peso");
			return;
		}
		for(int i = 0; i < inventario.length; i++) {
			if(inventario[i] == null) {
				inventario[i] = item;
				entro = true;
				break;
			}
		}
		
		if(!entro) {
			System.out.println("No queda suficiente espacio en inventario");
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getHp() {
		return hp;
	}

	public Item[] getInventario() {
		return inventario;
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public double getEspacio() {
		return espacio;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", hp=" + hp + "\n  inventario=" + Arrays.toString(inventario)
		+ "\n  capacidadCarga=" + capacidadCarga + ", espacio=" + espacio + "]";
	}
}
