package com.edutecno;

public class Hamburguesa implements MenuItem{
	private String name;
	private Double price;
	
	
	public Hamburguesa(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void print() {
		System.out.println(name + " " + price);
	}

	@Override
	public String toString() {
		return "Hamburguesa [name=" + name + ", price=" + price + "]\n";
	}

}
