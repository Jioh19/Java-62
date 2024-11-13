package com.edutecno;

public class FiguraCompuesta implements Figuras{

	private String nombre;
	private Figuras[] figuras;
	public FiguraCompuesta(String nombre, Figuras[] figuras) {
		super();
		this.nombre = nombre;
		this.figuras = figuras;
	}
	@Override
	public double getArea() {
		double total = 0;
		
		for(Figuras fig : figuras) {
			if(fig != null) {
				total += fig.getArea();
			}
		}
		return total;
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	@Override
	public String toString() {
		return "FiguraCompuesta [getArea()=" + getArea() + ", getNombre()=" + getNombre() + "]";
	}
	
	
	
}
