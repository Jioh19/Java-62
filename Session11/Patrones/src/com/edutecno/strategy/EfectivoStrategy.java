package com.edutecno.strategy;

//Implementación de la estrategia de pago. Sólo interesa que implemente el método pago.
//Toda la lógica correspondiente al pago en efectivo en si se maneja de manera externa
public class EfectivoStrategy implements PagoStrategy{

	@Override
	public void pago(int monto) {
		System.out.println("Pagando en efectivo: $" + monto);
	}
	
}
