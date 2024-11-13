package modelos;

import interfaces.ProductoInterface;

public class Refrigerador extends Producto implements ProductoInterface {
	private int puertas;
	private String gasto;

	public Refrigerador(int precio, int stock, int puertas, String gasto) {
		super(precio, stock);
		this.puertas = puertas;
		this.gasto = gasto;
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
	public String toString() {
		return "Refrigerador [puertas=" + puertas + ", gasto=" + gasto + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}
	
	
}
