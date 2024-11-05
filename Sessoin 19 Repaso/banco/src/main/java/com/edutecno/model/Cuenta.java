package com.edutecno.model;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.excepciones.CuentaException;
import com.edutecno.service.TransaccionService;

public abstract class Cuenta {
	protected String numero;
	protected double saldo;
	protected Cliente cliente;
	protected TransaccionService transaccionService;
	
	public Cuenta(String numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		saldo = 0;
		transaccionService = new TransaccionService(new ArrayList<>());
	}
	
	public abstract void depositar(double deposito) throws CuentaException;
	public abstract void retirar(double retiro) throws CuentaException;
	public abstract boolean canDepositar(double deposito);
	public abstract boolean canRetirar(double retiro);

	public TransaccionService getTransaccionService() {
		return transaccionService;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	
}
