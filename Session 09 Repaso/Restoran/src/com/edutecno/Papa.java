package com.edutecno;

public class Papa implements MenuItem{
	private String name;
	private Double price;
	
	public Papa(String name, Double price) {
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
		// TODO Auto-generated method stub
		System.out.println(name + " " + price);
	}

	@Override
	public String toString() {
		return "Papa [name=" + name + ", price=" + price + "]\n";
	}

}
