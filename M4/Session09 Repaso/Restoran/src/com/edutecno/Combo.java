package com.edutecno;

import java.util.Arrays;

public class Combo implements MenuItem{

	private String name;
	private MenuItem[] items;
	
	
	public Combo(String name, MenuItem[] items) {
		super();
		this.name = name;
		this.items = items;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Double getPrice() {
		Double total = 0.0;
		for(MenuItem item: items) {
			total += item.getPrice();
		}
		return total*0.9;
	}

	@Override
	public void print() {
		System.out.println(name + " "+  getPrice() + " " + Arrays.toString(items) );
	}

	@Override
	public String toString() {
		return "Combo [name=" + name + ", price=" + getPrice() +  ", items=" + Arrays.toString(items) + "]\n";
	}

}
