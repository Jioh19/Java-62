package modelos;

import interfaces.CocinaInterface;

public class Cocina extends Producto implements CocinaInterface {

	private int quemadores;

	public Cocina(int precio, int stock, int quemadores) {
		super(precio, stock);
		this.quemadores = quemadores;
	}

	@Override
	public void cambiarPrecio(int precio) {
		this.precio = precio;

	}

	@Override
	public void cambiarStock(int stock) {
		
		if(this.stock > stock) {
			this.stock -= stock;			
		}

	}

	@Override
	public boolean incluyeGas() {
	
		return false;
	}

	@Override
	public String toString() {
		return "Valor: " + precio + "\nCuenta con: " + quemadores + 
				" quemadores\nArticulos disponibles: " + stock;  
	}

	public int getQuemadores() {
		return quemadores;
	}

	public void setQuemadores(int quemadores) {
		this.quemadores = quemadores;
	}
	
	
}
