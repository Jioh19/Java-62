package com.edutecno.strategy;

import java.time.LocalDate;
//Implementación de la estrategia de pago. Sólo interesa que implemente el método pago.
//Toda la lógica correspondiente a la tarjeta de crédito en si se maneja de manera externa
public class TarjetaCreditoStrategy implements PagoStrategy{
	private String nombre;
	private String numero;
	public TarjetaCreditoStrategy(String nombre, String numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}
	@Override
	public void pago(int monto) {
		System.out.println("Pagando con tarjeta de credito: $" + monto);
	}
}
