package com.edutecno;

public class CuentaCorriente implements Cuenta{

	protected String numCuenta;
	protected Cliente cliente;
	protected double saldo;
	
	

	public CuentaCorriente(String numCuenta, Cliente cliente) {
		super();
		this.numCuenta = numCuenta;
		this.cliente = cliente;
		this.saldo = 0;
	}

	@Override
	public boolean depositar(double deposito) {
		this.saldo += deposito;
		return true;
	}

	@Override
	public boolean retirar(double retiro) {
		if(saldo < retiro) {
			return false;
		}
		saldo -= retiro;
		return true;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [numCuenta=" + numCuenta + ", cliente=" + cliente + ", saldo=" + saldo + "]";
	}
	
	
	
	

}
