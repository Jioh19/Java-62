package modelos;

public abstract class Producto {
	protected int precio;
	protected int stock;
	public Producto(int precio, int stock) {
		super();
		this.precio = precio;
		this.stock = stock;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
