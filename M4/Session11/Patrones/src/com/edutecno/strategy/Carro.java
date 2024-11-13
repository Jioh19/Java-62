package com.edutecno.strategy;
//Clase Carro, esta recibe la estrategia de pego (forma de pago) y tiene el método "pagar"

public class Carro {
	private PagoStrategy pagoStrategy;
	
	public void setPagoStrategy(PagoStrategy strategy) {
		this.pagoStrategy = strategy;
	}
	
	public void pagar(int monto) {
		pagoStrategy.pago(monto);
	}
}
