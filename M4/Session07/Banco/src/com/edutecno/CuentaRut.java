package com.edutecno;

public class CuentaRut implements Cuenta{
	private double totalDepositoMensual;
	private double limite;
	protected String numCuenta;
	protected Cliente cliente;
	protected double saldo;
	
	

	public CuentaRut(String numCuenta, Cliente cliente) {
		super();
		this.numCuenta = numCuenta;
		this.cliente = cliente;
		this.saldo = 0;
		this.totalDepositoMensual = 0;
		this.limite = 3000000;
	}

	@Override
	public boolean depositar(double deposito) {
		if(limite < deposito + totalDepositoMensual) {
			return false;
		}
		limite += deposito;
		saldo += deposito;
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
		return "CuentaRut [totalDepositoMensual=" + totalDepositoMensual + ", limite=" + limite + ", numCuenta="
				+ numCuenta + ", cliente=" + cliente + ", saldo=" + saldo + "]";
	}
	
}
