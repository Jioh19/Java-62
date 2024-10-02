package com.edutecno;

public abstract class Cuenta {
	protected String numCuenta;
	protected Cliente cliente;
	protected double saldo;
	
	

	public Cuenta(String numCuenta, Cliente cliente) {
		super();
		this.numCuenta = numCuenta;
		this.cliente = cliente;
		this.saldo = 0;
	}
	public abstract boolean depositar(double deposito);
	public abstract boolean retirar(double retiro);
	
}
