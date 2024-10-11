package com.edutecno.strategy;

//Interface de Pago. Solo interesa que se implemente el pago.
public interface PagoStrategy {
	void pago(int monto);
}
