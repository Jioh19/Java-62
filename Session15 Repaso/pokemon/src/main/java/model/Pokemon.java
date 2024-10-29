package model;

import java.util.List;

public class Pokemon {
	private String name;
	private List<Response> movimientos;
	
	
	
	public Pokemon(String name, List<Response> movimientos) {
		super();
		this.name = name;
		this.movimientos = movimientos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Response> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Response> movimientos) {
		this.movimientos = movimientos;
	}
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", movimientos=" + movimientos + "]";
	}
	
	
}
