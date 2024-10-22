package com.edutecno.model;

public class CuentaCorriente extends Cuenta {
	private double topeMaximo;
	private double depositoActual;

	public CuentaCorriente(String numero, Cliente cliente) {
		super(numero, cliente);
		topeMaximo = 10000000;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean depositar(double deposito) {
		if (topeMaximo < depositoActual + deposito) {
			return false;
		}
		saldo += deposito;
		depositoActual += deposito;
		return true;
	}

	@Override
	public boolean retirar(double retiro) {
		if (saldo < retiro) {
			return false;
		}
		saldo -= retiro;
		return true;
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
