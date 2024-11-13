package com.edutecno;

public class Main {
	public static void main(String[] args) {
		EstadoCarrito estado = new EstadoVacio();
		CarritoCompras carrito = new CarritoCompras(estado);
		System.out.println(carrito);
		carrito.agregar("Queso");
		System.out.println(carrito);
		carrito.agregar("Carne");
		System.out.println(carrito);
//		carrito.cancelar();
//		System.out.println(carrito);
		carrito.agregar("Jamon");
		carrito.siguiente();
		System.out.println(carrito);
		carrito.siguiente();
		System.out.println(carrito);
		carrito.siguiente();
		System.out.println(carrito);
	}
}
