package com.edutecno.strategy;

public class Main {
	public static void main(String[] args) {
		Carro carrito = new Carro();
		//Finalmente, independiente de las diferencias intrínsecas al método de pago, 
		//el método "pago" funciona de manera similar a ambas estrategias
		PagoStrategy pago1 = new TarjetaCreditoStrategy("Juan", "123456");
		carrito.setPagoStrategy(pago1);
		carrito.pagar(12000);
		
		PagoStrategy pago2 = new EfectivoStrategy();
		carrito.setPagoStrategy(pago2);
		carrito.pagar(20000);
	}
}
