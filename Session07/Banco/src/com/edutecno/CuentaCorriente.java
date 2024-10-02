package com.edutecno;

public class CuentaCorriente extends Cuenta{

	public CuentaCorriente(String numCuenta, Cliente cliente) {
		super(numCuenta, cliente);
		// TODO Auto-generated constructor stub
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
