package com.edutecno.cuenta;

import com.edutecno.cliente.Cliente;

public abstract class Cuenta {
	protected String numero;
	protected double saldo;
	protected Cliente cliente;
	
	public abstract boolean depositar(double deposito);
	public abstract boolean retirar(double retiro);
	
	public Cuenta(String numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0;
	}
	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	
}
