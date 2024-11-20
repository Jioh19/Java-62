package model;

public class Producto {
	private String id;
	private String nombre;
	private int precio;
	private int stock;
	
	public Producto(String id, String nombre, int precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public int getStock() {
		return stock;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
}
