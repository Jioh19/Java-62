package com.edutecno.model;

import com.edutecno.excepciones.CuentaException;

public class CuentaCorriente extends Cuenta {
	private double topeMaximo;
	private double depositoActual;

	public CuentaCorriente(String numero, Cliente cliente) {
		super(numero, cliente);
		topeMaximo = 10000000;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositar(double deposito) throws CuentaException {
		if (topeMaximo < depositoActual + deposito) {
			throw new CuentaException("Error en deposito");
		}
		saldo += deposito;
		depositoActual += deposito;
		
	}

	@Override
	public void retirar(double retiro) throws CuentaException {
		if (saldo < retiro) {
			throw new CuentaException("Error en retiro");
		}
		saldo -= retiro;
	}

	@Override
	public boolean canDepositar(double deposito) {
		if (topeMaximo < depositoActual + deposito) {
			return false;
		}
		return true;
	}

	@Override
	public boolean canRetirar(double retiro) {
		if (saldo < retiro) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("\nCuentaCorriente [numero=%s, saldo=%s, transacciones=%s, titular=%s]", 
				numero, saldo, transaccionService.getTransacciones(), cliente.getRut());
	}

}
